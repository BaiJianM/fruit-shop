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
@Schema(description = "cart表")
@TableName("hiolabs_cart")
public class Cart {

    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("goods_id")
    private Long goodsId;

    @JsonProperty("goods_sn")
    private String goodsSn;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("goods_name")
    private String goodsName;

    @JsonProperty("goods_aka")
    private String goodsAka;

    @JsonProperty("goods_weight")
    private Double goodsWeight;

    @JsonProperty("add_price")
    private BigDecimal addPrice;

    @JsonProperty("retail_price")
    private BigDecimal retailPrice;

    private Long number;

    @JsonProperty("goods_specifition_name_value")
    private String goodsSpecifitionNameValue;

    @JsonProperty("goods_specifition_ids")
    private String goodsSpecifitionIds;

    private Boolean checked;

    @JsonProperty("list_pic_url")
    private String listPicUrl;

    @JsonProperty("freight_template_id")
    private Long freightTemplateId;

    @JsonProperty("is_on_sale")
    private Boolean isOnSale;

    @JsonProperty("add_time")
    private Integer addTime;

    @JsonProperty("is_fast")
    private Boolean isFast;

    @JsonProperty("is_delete")
    private Boolean isDelete;

}