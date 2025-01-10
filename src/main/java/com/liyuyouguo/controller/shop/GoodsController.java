package com.liyuyouguo.controller.shop;

import com.liyuyouguo.annotations.FruitShopController;
import com.liyuyouguo.beans.vo.shop.GoodsInfoVo;
import com.liyuyouguo.commons.FruitShopResponse;
import com.liyuyouguo.service.shop.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品控制层
 *
 * @author baijianmin
 */
@Slf4j
@FruitShopController("/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    /**
     * 获取商品详情
     *
     * @param goodsId 商品id
     * @return GoodsInfoVo 商品信息
     */
    @GetMapping("/detail")
    public FruitShopResponse<GoodsInfoVo> getGoodsDetail(@RequestParam("id") Integer goodsId) {
        return FruitShopResponse.success(goodsService.getGoodsDetail(goodsId));
    }

    /**
     * 在售的商品总数
     *
     * @return Integer 在售的商品总数
     */
    @GetMapping("/count")
    public FruitShopResponse<Integer> getGoodsCount() {
        return FruitShopResponse.success(goodsService.getGoodsCount());
    }

}
