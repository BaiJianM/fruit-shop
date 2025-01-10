package com.liyuyouguo.service.shop;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyuyouguo.entity.fruitshop.Category;
import com.liyuyouguo.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.Collections;
import java.util.List;

/**
 * 商品分类服务类
 *
 * @author baijianmin
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryMapper categoryMapper;

    /**
     * 获取商品目录
     *
     * @param categoryId 分类id
     * @return List<Category> 目录列表
     */
    public List<Category> getCatalog(Integer categoryId) {
        List<Category> records = categoryMapper.selectPage(new Page<>(1, 10), Wrappers.lambdaQuery(Category.class)
                .eq(Category::getParentId, 0)
                .eq(Category::getIsCategory, 1)
                .orderByAsc(Category::getSortOrder)).getRecords();
        return records == null ? Collections.emptyList() : records;
    }

}
