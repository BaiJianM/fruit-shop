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
@Schema(description = "hiolabs_order_goods 表")
@TableName("hiolabs_order_goods")
public class OrderGoods {

    private Long id;

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("goods_id")
    private Long goodsId;

    @JsonProperty("goods_name")
    private String goodsName;

    @JsonProperty("goods_aka")
    private String goodsAka;

    @JsonProperty("product_id")
    private Long productId;

    private Integer number;

    @JsonProperty("retail_price")
    private BigDecimal retailPrice;

    @JsonProperty("goods_specification_name_value")
    private String goodsSpecificationNameValue;

    @JsonProperty("goods_specification_ids")
    private String goodsSpecificationIds;

    @JsonProperty("list_pic_url")
    private String listPicUrl;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("is_delete")
    private Boolean isDelete;

}