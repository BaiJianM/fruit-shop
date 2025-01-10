package com.liyuyouguo.beans.vo.shop;

import com.liyuyouguo.entity.fruitshop.Category;
import com.liyuyouguo.entity.fruitshop.Goods;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author baijianmin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryVo extends Category {

    private List<Goods> goodsList;
}
