package com.liyuyouguo.controller.shop;

import com.liyuyouguo.annotations.FruitShopController;
import com.liyuyouguo.beans.vo.shop.CartCountVo;
import com.liyuyouguo.commons.FruitShopResponse;
import com.liyuyouguo.service.shop.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author baijianmin
 */
@Slf4j
@FruitShopController("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    /**
     * 获取购物车商品的总件件数
     *
     * @return CartCountVo 购物车件数
     */
    @GetMapping("/goodsCount")
    public FruitShopResponse<CartCountVo> getGoodsCount() {
        return FruitShopResponse.success(cartService.getGoodsCount());
    }

}
