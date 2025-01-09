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
@Schema(description = "hiolabs_order 表")
@TableName("hiolabs_order")
public class Order {

    private Long id;

    @JsonProperty("order_sn")
    private String orderSn;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("order_status")
    private Integer orderStatus;

    @JsonProperty("offline_pay")
    private Integer offlinePay;

    @JsonProperty("shipping_status")
    private Integer shippingStatus;

    @JsonProperty("print_status")
    private Boolean printStatus;

    @JsonProperty("pay_status")
    private Integer payStatus;

    private String consignee;

    private Integer country;

    private Integer province;

    private Integer city;

    private Integer district;

    private String address;

    @JsonProperty("print_info")
    private String printInfo;

    private String mobile;

    private String postscript;

    @JsonProperty("admin_memo")
    private String adminMemo;

    @JsonProperty("shipping_fee")
    private Double shippingFee;

    @JsonProperty("pay_name")
    private String payName;

    @JsonProperty("pay_id")
    private String payId;

    @JsonProperty("change_price")
    private BigDecimal changePrice;

    @JsonProperty("actual_price")
    private BigDecimal actualPrice;

    @JsonProperty("order_price")
    private BigDecimal orderPrice;

    @JsonProperty("goods_price")
    private BigDecimal goodsPrice;

    @JsonProperty("add_time")
    private Integer addTime;

    @JsonProperty("pay_time")
    private Integer payTime;

    @JsonProperty("shipping_time")
    private Integer shippingTime;

    @JsonProperty("confirm_time")
    private Integer confirmTime;

    @JsonProperty("dealdone_time")
    private Integer dealdoneTime;

    @JsonProperty("freight_price")
    private Integer freightPrice;

    @JsonProperty("express_value")
    private BigDecimal expressValue;

    private String remark;

    @JsonProperty("order_type")
    private Integer orderType;

    @JsonProperty("is_delete")
    private Boolean isDelete;

}