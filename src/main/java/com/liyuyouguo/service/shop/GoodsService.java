package com.liyuyouguo.service.shop;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyuyouguo.beans.vo.shop.GoodsInfoVo;
import com.liyuyouguo.beans.vo.shop.ProductInfoVo;
import com.liyuyouguo.commons.FruitShopException;
import com.liyuyouguo.commons.ShopError;
import com.liyuyouguo.entity.fruitshop.Goods;
import com.liyuyouguo.entity.fruitshop.GoodsGallery;
import com.liyuyouguo.entity.fruitshop.GoodsSpecification;
import com.liyuyouguo.entity.fruitshop.Product;
import com.liyuyouguo.mapper.FootPrintMapper;
import com.liyuyouguo.mapper.GoodsGalleryMapper;
import com.liyuyouguo.mapper.GoodsMapper;
import com.liyuyouguo.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务类
 *
 * @author baijianmin
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsMapper goodsMapper;

    private final GoodsGalleryMapper galleryMapper;

    private final FootPrintService footPrintService;

    private final ProductService productService;

    public GoodsInfoVo getGoodsDetail(Integer goodsId) {
        // TODO 这里少一个从token获取登录人id的操作
        Integer userId = 1048;
        // 获取商品
        Goods goods = goodsMapper.selectOne(Wrappers.lambdaQuery(Goods.class)
                .eq(Goods::getId, goodsId)
                .eq(Goods::getIsDelete, 0));
        if (goods == null) {
            throw new FruitShopException(ShopError.GOODS_NOT_EXIST);
        }
        List<GoodsGallery> goodsGalleries = galleryMapper.selectPage(new Page<>(1, 6), Wrappers.lambdaQuery(GoodsGallery.class)
                .eq(GoodsGallery::getGoodsId, goodsId)
                .eq(GoodsGallery::getIsDelete, 0)
                .orderByAsc(GoodsGallery::getSortOrder)).getRecords();
        // 新增或更新用户足迹
        footPrintService.saveFootPrint(userId, goodsId);
        ProductInfoVo productInfoVo = productService.getSpecificationList(goodsId);
        List<Product> products = productService.getProductList(goodsId);
        int goodsNumber = products.stream().filter(p -> p.getGoodsNumber() > 0).mapToInt(Product::getGoodsNumber).sum();
        goods.setGoodsNumber(goodsNumber);

        GoodsInfoVo goodsInfoVo = new GoodsInfoVo();
        goodsInfoVo.setInfo(goods);
        goodsInfoVo.setGallery(goodsGalleries);
        goodsInfoVo.setSpecificationList(productInfoVo);
        goodsInfoVo.setProductList(products);
        return goodsInfoVo;
    }

    /**
     * 在售的商品总数
     *
     * @return Integer 在售的商品总数
     */
    public Integer getGoodsCount() {
        List<Goods> goods = goodsMapper.selectList(Wrappers.lambdaQuery(Goods.class)
                .eq(Goods::getIsOnSale, 1)
                .eq(Goods::getIsDelete, 0));
        return goods.size();
    }
}
