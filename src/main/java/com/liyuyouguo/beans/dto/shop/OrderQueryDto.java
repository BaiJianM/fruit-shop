package com.liyuyouguo.beans.dto.shop;

import com.liyuyouguo.beans.FruitShopPage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author baijianmin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderQueryDto extends FruitShopPage {

    private Integer showType;

}
