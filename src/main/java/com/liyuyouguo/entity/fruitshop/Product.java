package com.liyuyouguo.entity.fruitshop;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author baijianmin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "hiolabs_product 表")
@TableName("hiolabs_product")
public class Product {

    private Long id;

    @JsonProperty("goods_id")
    private Long goodsId;

    @JsonProperty("goods_specification_ids")
    private String goodsSpecificationIds;

    @JsonProperty("goods_sn")
    private String goodsSn;

    @JsonProperty("goods_number")
    private Long goodsNumber;

    @JsonProperty("retail_price")
    private BigDecimal retailPrice;

    private BigDecimal cost;

    @JsonProperty("goods_weight")
    private Double goodsWeight;

    @JsonProperty("has_change")
    private Boolean hasChange;

    @JsonProperty("goods_name")
    private String goodsName;

    @JsonProperty("is_on_sale")
    private Boolean isOnSale;

    @JsonProperty("is_delete")
    private Boolean isDelete;

}