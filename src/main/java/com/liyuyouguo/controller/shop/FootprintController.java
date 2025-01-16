package com.liyuyouguo.controller.shop;

import com.liyuyouguo.annotations.FruitShopController;
import com.liyuyouguo.beans.FruitShopPage;
import com.liyuyouguo.beans.PageResult;
import com.liyuyouguo.commons.FruitShopResponse;
import com.liyuyouguo.entity.fruitshop.Footprint;
import com.liyuyouguo.service.shop.FootPrintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author baijianmin
 */
@Slf4j
@FruitShopController("/footprint")
@RequiredArgsConstructor
public class FootprintController {

    private final FootPrintService footPrintService;

    /**
     * 删除当天的同一个商品的足迹
     *
     * @param footprintId 足迹id
     * @return String 删除结果
     */
    @PostMapping("/delete")
    public FruitShopResponse<String> delete(@RequestParam("footprintId") Integer footprintId) {
        return FruitShopResponse.success(footPrintService.delete(footprintId));
    }

    /**
     * 获取用户足迹
     *
     * @param pageDto 分页参数
     * @return PageResult<Footprint> 用户足迹
     */
    @PostMapping("/list")
    public FruitShopResponse<PageResult<Footprint>> getFootprintList(@RequestBody FruitShopPage pageDto) {
        return FruitShopResponse.success(footPrintService.getFootprintList(pageDto));
    }

}
