package com.liyuyouguo.service.shop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liyuyouguo.beans.vo.shop.CategoryVo;
import com.liyuyouguo.commons.FruitShopException;
import com.liyuyouguo.commons.ShopError;
import com.liyuyouguo.entity.fruitshop.*;
import com.liyuyouguo.mapper.*;
import com.liyuyouguo.utils.ConvertUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 首页服务类
 *
 * @author baijianmin
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class IndexService {

    private final ShowSettingsMapper showSettingsMapper;

    private final AdMapper adMapper;

    private final NoticeMapper noticeMapper;

    private final CategoryMapper categoryMapper;

    private final GoodsMapper goodsMapper;

    private final CartMapper cartMapper;

    /**
     * 获取首页显示配置
     *
     * @return ShowSettings 首页显示配置实体类
     */
    public ShowSettings getShowSettings() {
        return showSettingsMapper.selectById(1);
    }

    /**
     * 获取小程序信息
     */
    public void getAppInfo() {
        List<Ad> ads = adMapper.selectList(Wrappers.lambdaQuery(Ad.class)
                .eq(Ad::getEnabled, 1)
                .eq(Ad::getIsDelete, 0)
                .orderByAsc(Ad::getSortOrder));
        List<Notice> notices = noticeMapper.selectList(Wrappers.lambdaQuery(Notice.class)
                .eq(Notice::getIsDelete, 0));
        List<Category> channels = categoryMapper.selectList(Wrappers.lambdaQuery(Category.class)
                .eq(Category::getIsChannel, 1)
                .eq(Category::getParentId, 0)
                .orderByAsc(Category::getSortOrder));
        List<Category> categories = categoryMapper.selectList(Wrappers.lambdaQuery(Category.class)
                .eq(Category::getIsShow, 1)
                .eq(Category::getParentId, 0)
                .orderByAsc(Category::getSortOrder));
        Collection<CategoryVo> categoryVos = ConvertUtils.convertCollection(categories, CategoryVo::new)
                .orElseThrow(() -> new FruitShopException(ShopError.INDEX_ERROR));
        categoryVos.forEach(categoryVo -> {
            List<Goods> goods = goodsMapper.selectList(Wrappers.lambdaQuery(Goods.class)
                    .eq(Goods::getCategoryId, categoryVo.getId())
                    .ge(Goods::getGoodsNumber, 0)
                    .eq(Goods::getIsOnSale, 1)
                    .eq(Goods::getIsIndex, 0)
                    .eq(Goods::getIsDelete, 0)
                    .orderByAsc(Goods::getSortOrder));
            categoryVo.setGoodsList(goods);
        });
        // TODO 这里少一个从token获取登录人id的操作
        Long userId = 1L;
        List<Cart> carts = cartMapper.selectList(Wrappers.lambdaQuery(Cart.class)
                .eq(Cart::getUserId, userId)
                .eq(Cart::getIsDelete, 0));
        long sum = carts.stream().mapToLong(Cart::getNumber).sum();
    }

}