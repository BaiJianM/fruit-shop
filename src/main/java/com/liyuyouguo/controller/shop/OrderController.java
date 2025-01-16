package com.liyuyouguo.controller.shop;

import com.liyuyouguo.annotations.FruitShopController;
import com.liyuyouguo.beans.PageResult;
import com.liyuyouguo.beans.dto.shop.OrderQueryDto;
import com.liyuyouguo.beans.vo.shop.OrderCountVo;
import com.liyuyouguo.beans.vo.shop.OrderVo;
import com.liyuyouguo.commons.FruitShopResponse;
import com.liyuyouguo.service.shop.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 订单控制层
 *
 * @author baijianmin
 */
@Slf4j
@FruitShopController("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * 我的页面获取订单数状态
     *
     * @return OrderCountVo 订单数
     */
    @GetMapping("/orderCount")
    public FruitShopResponse<OrderCountVo> getOrderStatusCount() {
        return FruitShopResponse.success(orderService.getOrderStatusCount());
    }

    /**
     * 获取订单列表
     *
     * @param dto 传参
     * @return PageResult<OrderVo> 订单信息分页
     */
    @PostMapping("/list")
    public FruitShopResponse<PageResult<OrderVo>> getOrderList(@RequestBody OrderQueryDto dto) {
        return FruitShopResponse.success(orderService.getOrderList(dto));
    }

    /**
     * 获取订单数量
     *
     * @return Long 订单数量
     */
    @GetMapping("/count")
    public FruitShopResponse<Long> getOrderCount(@RequestParam("showType") Integer showType) {
        return FruitShopResponse.success(orderService.getOrderCount(showType));
    }

}
