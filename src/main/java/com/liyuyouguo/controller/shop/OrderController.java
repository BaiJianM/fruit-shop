package com.liyuyouguo.controller.shop;

import com.liyuyouguo.annotations.FruitShopController;
import com.liyuyouguo.beans.vo.shop.OrderCountVo;
import com.liyuyouguo.commons.FruitShopResponse;
import com.liyuyouguo.service.shop.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

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
    public FruitShopResponse<OrderCountVo> getOrderCount() {
        return FruitShopResponse.success(orderService.getOrderCount());
    }

}
