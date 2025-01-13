package com.liyuyouguo.service.shop;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liyuyouguo.beans.vo.shop.OrderCountVo;
import com.liyuyouguo.entity.fruitshop.Order;
import com.liyuyouguo.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

    /**
     * 我的页面获取订单数状态
     *
     * @return OrderCountVo 订单数
     */
    public OrderCountVo getOrderCount() {
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
}
