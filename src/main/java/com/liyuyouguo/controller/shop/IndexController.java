package com.liyuyouguo.controller.shop;

import com.liyuyouguo.annotations.FruitShopController;
import com.liyuyouguo.commons.FruitShopResponse;
import com.liyuyouguo.entity.fruitshop.ShowSettings;
import com.liyuyouguo.service.shop.IndexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页显示配置控制层
 *
 * @author baijianmin
 */
@Slf4j
@FruitShopController("/settings")
@RequiredArgsConstructor
public class IndexController {

    private final IndexService indexService;

    /**
     * 获取首页显示配置
     *
     * @return ShowSettings 首页显示配置实体类
     */
    @GetMapping("/showSettings")
    public FruitShopResponse<ShowSettings> showSettings() {
        return FruitShopResponse.success(indexService.getShowSettings());
    }

}
