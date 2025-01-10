package com.liyuyouguo.service.shop;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liyuyouguo.beans.vo.shop.GoodsSpecificationVo;
import com.liyuyouguo.beans.vo.shop.ProductInfoVo;
import com.liyuyouguo.commons.FruitShopException;
import com.liyuyouguo.commons.ShopError;
import com.liyuyouguo.entity.fruitshop.GoodsSpecification;
import com.liyuyouguo.entity.fruitshop.Product;
import com.liyuyouguo.entity.fruitshop.Specification;
import com.liyuyouguo.mapper.GoodsSpecificationMapper;
import com.liyuyouguo.mapper.ProductMapper;
import com.liyuyouguo.mapper.SpecificationMapper;
import com.liyuyouguo.utils.ConvertUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baijianmin
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final GoodsSpecificationMapper goodsSpecificationMapper;

    public final ProductMapper productMapper;

    private final SpecificationMapper specificationMapper;

    /**
     * 获取商品的规格信息
     *
     * @param goodsId 商品id
     * @return ProductInfoVo 商品的规格信息
     */
    public ProductInfoVo getSpecificationList(Integer goodsId) {
        // 根据sku商品信息，查找规格值列表
        List<GoodsSpecification> gSpecList = goodsSpecificationMapper.selectList(Wrappers.lambdaQuery(GoodsSpecification.class)
                .eq(GoodsSpecification::getGoodsId, goodsId)
                .eq(GoodsSpecification::getIsDelete, 0));
        for (GoodsSpecification gSpec : gSpecList) {
            GoodsSpecificationVo gSpecVo = ConvertUtils.convert(gSpec, GoodsSpecificationVo::new)
                    .orElseThrow(() -> new FruitShopException(ShopError.SKU_ERROR));
            Product product = productMapper.selectOne(Wrappers.lambdaQuery(Product.class)
                    .eq(Product::getGoodsSpecificationIds, gSpec.getId())
                    .eq(Product::getIsDelete, 0));
            gSpecVo.setGoodsNumber(product.getGoodsNumber());
        }
        Integer specId = gSpecList.get(0).getSpecificationId();
        Specification spec = specificationMapper.selectOne(Wrappers.lambdaQuery(Specification.class)
                .eq(Specification::getId, specId));
        ProductInfoVo productInfoVo = new ProductInfoVo();
        productInfoVo.setSpecificationId(specId);
        productInfoVo.setName(spec.getName());
        productInfoVo.setValueList(gSpecList);
        return productInfoVo;
    }

    public List<Product> getProductList(Integer goodsId) {
        return productMapper.selectList(Wrappers.lambdaQuery(Product.class)
                .eq(Product::getGoodsId, goodsId)
                .eq(Product::getIsDelete, 0));
    }

}
