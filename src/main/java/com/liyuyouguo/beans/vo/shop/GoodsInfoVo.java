package com.liyuyouguo.beans.vo.shop;

import com.liyuyouguo.entity.fruitshop.Goods;
import com.liyuyouguo.entity.fruitshop.GoodsGallery;
import com.liyuyouguo.entity.fruitshop.GoodsSpecification;
import com.liyuyouguo.entity.fruitshop.Product;
import lombok.Data;

import java.util.List;

/**
 * 商品信息
 *
 * @author baijianmin
 */
@Data
public class GoodsInfoVo {

    private Goods info;

    private List<GoodsGallery> gallery;

    private ProductInfoVo specificationList;

    private List<Product> productList;

}
