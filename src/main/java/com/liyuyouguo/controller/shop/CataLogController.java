package com.liyuyouguo.controller.shop;

import com.liyuyouguo.annotations.FruitShopController;
import com.liyuyouguo.commons.FruitShopResponse;
import com.liyuyouguo.entity.fruitshop.Category;
import com.liyuyouguo.service.shop.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品目录控制层
 *
 * @author baijianmin
 */
@Slf4j
@FruitShopController("/catalog")
@RequiredArgsConstructor
public class CataLogController {

    private final CategoryService categoryService;

    /**
     * 获取商品目录
     *
     * @param categoryId 分类id
     * @return List<Category> 目录列表
     */
    @GetMapping("/index")
    public FruitShopResponse<List<Category>> getCatalog(@RequestParam(value = "id", required = false) Integer categoryId) {
        return FruitShopResponse.success(categoryService.getCatalog(categoryId));
    }

}
