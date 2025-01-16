package com.liyuyouguo.service.shop;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyuyouguo.beans.PageResult;
import com.liyuyouguo.beans.dto.shop.OrderQueryDto;
import com.liyuyouguo.beans.vo.shop.OrderCountVo;
import com.liyuyouguo.beans.vo.shop.OrderHandleOptionVo;
import com.liyuyouguo.beans.vo.shop.OrderVo;
import com.liyuyouguo.commons.FruitShopException;
import com.liyuyouguo.commons.ShopError;
import com.liyuyouguo.entity.fruitshop.Order;
import com.liyuyouguo.entity.fruitshop.OrderGoods;
import com.liyuyouguo.mapper.OrderGoodsMapper;
import com.liyuyouguo.mapper.OrderMapper;
import com.liyuyouguo.utils.ConvertUtils;
import com.liyuyouguo.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 订单服务类
 *
 * @author baijianmin
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    private final OrderGoodsMapper orderGoodsMapper;

    /**
     * 我的页面获取订单数状态
     *
     * @return OrderCountVo 订单数
     */
    public OrderCountVo getOrderStatusCount() {
        // TODO 这里少一个从token获取登录人id的操作
        Integer userId = 1048;
        if (userId != 0) {
            OrderCountVo vo = new OrderCountVo();
            Long toPay = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                    .eq(Order::getUserId, userId)
                    .eq(Order::getIsDelete, 0)
                    .lt(Order::getOrderType, 7)
                    .in(Order::getOrderStatus, Arrays.asList(101, 801)));
            vo.setToPay(toPay);
            Long toDelivery = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                    .eq(Order::getUserId, userId)
                    .eq(Order::getIsDelete, 0)
                    .lt(Order::getOrderType, 7)
                    .eq(Order::getOrderStatus, 300));
            vo.setToDelivery(toDelivery);
            Long toReceive = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                    .eq(Order::getUserId, userId)
                    .eq(Order::getIsDelete, 0)
                    .lt(Order::getOrderType, 7)
                    .eq(Order::getOrderStatus, 301));
            vo.setToReceive(toReceive);
            return vo;
        }
        return null;
    }

    /**
     * 获取订单列表
     *
     * @param dto 传参
     * @return PageResult<OrderVo> 订单信息分页
     */
    public PageResult<OrderVo> getOrderList(OrderQueryDto dto) {
        // TODO 这里少一个从token获取登录人id的操作
        Integer userId = 1048;
        // 根据 showType 获取订单状态列表
        List<Integer> statusList = this.getOrderStatus(dto.getShowType());
        Page<Order> page = new Page<>(dto.getCurrent(), dto.getSize());
        // 查询订单列表
        Page<Order> orderPage = orderMapper.selectPage(page, Wrappers.lambdaQuery(Order.class)
                .eq(Order::getUserId, userId)
                .eq(Order::getIsDelete, 0)
                .lt(Order::getOrderType, 7)
                .in(Order::getOrderStatus, statusList)
                .orderByDesc(Order::getAddTime));
        // 处理订单数据
        List<OrderVo> orderVos = new ArrayList<>();
        for (Order order : orderPage.getRecords()) {
            Integer orderId = order.getId();
            OrderVo vo = new OrderVo();
            // 订单的商品
            List<OrderGoods> orderGoods = orderGoodsMapper.selectList(Wrappers.lambdaQuery(OrderGoods.class)
                    .eq(OrderGoods::getUserId, userId)
                    .eq(OrderGoods::getOrderId, orderId)
                    .eq(OrderGoods::getIsDelete, 0));
            vo.setGoodsList(orderGoods);
            int goodsCount = orderGoods.stream().mapToInt(OrderGoods::getNumber).sum();
            vo.setGoodsCount(goodsCount);
            vo.setAddTime(this.getOrderAddTime(orderId));
            // 订单状态的处理
            vo.setOrderStatusText(this.getOrderStatusText(orderId));
            vo.setHandleOption(this.getOrderHandleOption(orderId));
            orderVos.add(vo);
        }
        return ConvertUtils.convert(orderPage, PageResult<OrderVo>::new, (s, t) -> t.setRecords(orderVos)).orElseThrow();
    }

    public List<Integer> getOrderStatus(Integer showType) {
        List<Integer> status = new ArrayList<>();

        if (showType == null) {
            return Collections.emptyList();
        }

        switch (showType) {
            case 0:
                // 全部订单
                status.addAll(Arrays.asList(101, 102, 103, 201, 202, 203, 300, 301, 302, 303, 401));
                break;
            case 1:
                // 待付款订单
                status.add(101);
                break;
            case 2:
                // 待发货订单
                status.add(300);
                break;
            case 3:
                // 待收货订单
                status.add(301);
                break;
            case 4:
                // 待评价订单
                status.addAll(Arrays.asList(302, 303));
                break;
            default:
                return Collections.emptyList();
        }

        return status;
    }

    private String getOrderAddTime(Integer orderId) {
        return DateUtils.parseTime(orderMapper.selectById(orderId).getAddTime());
    }

    public String getOrderStatusText(Integer orderId) {
        // 根据订单ID查询订单信息
        Order orderInfo = orderMapper.selectById(orderId);
        if (orderInfo == null) {
            throw new FruitShopException(ShopError.ORDER_NOT_EXIST);
        }
        // 根据订单状态设置状态文本
        return switch (orderInfo.getOrderStatus()) {
            case 101 -> "待付款";
            case 102, 103 -> "交易关闭";
            case 201, 300 -> "待发货";
            case 301 -> "已发货";
            // 到时间，未收货的系统自动收货
            case 401 -> "交易成功";
            // 如果需要，处理未知状态
            default -> "未知状态";
        };
    }

    public OrderHandleOptionVo getOrderHandleOption(Integer orderId) {
        // 初始化操作选项
        OrderHandleOptionVo handleOption = new OrderHandleOptionVo();

        // 查询订单信息
        Order orderInfo = orderMapper.selectById(orderId);
        if (orderInfo == null) {
            throw new FruitShopException(ShopError.ORDER_NOT_EXIST);
        }

        // 获取订单状态
        Integer orderStatus = orderInfo.getOrderStatus();

        // 根据订单状态设置可操作选项
        switch (orderStatus) {
            // 订单刚创建，可以取消订单，可以继续支付
            case 101, 801:
                handleOption.setCancel(true);
                handleOption.setPay(true);
                break;
            // 如果订单被取消
            case 102, 103, 203, 401:
                handleOption.setDelete(true);
                break;
            // TODO 如果订单已付款，没有发货，则可退款操作（逻辑未实现）
            case 201:
                break;
            // 如果订单申请退款中，没有相关操作
            case 202:
                handleOption.setCancelRefund(true);
                break;
            // 如果订单已经发货，没有收货，则可收货操作
            case 301:
                handleOption.setConfirm(true);
                break;
            default:
                // 其他状态不设置操作选项
                break;
        }

        return handleOption;
    }

    /**
     * 获取订单数量
     *
     * @return Long 订单数量
     */
    public Long getOrderCount(Integer showType) {
        // TODO 这里少一个从token获取登录人id的操作
        Integer userId = 1048;
        List<Integer> statusList = this.getOrderStatus(showType);
        return orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                .eq(Order::getUserId, userId)
                .eq(Order::getIsDelete, 0)
                .in(Order::getOrderStatus, statusList));
    }
}
