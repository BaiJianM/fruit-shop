package com.liyuyouguo.entity.fruitshop;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author baijianmin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "hiolabs_order_express 表")
@TableName("hiolabs_order_express")
public class OrderExpress {

    private Long id;

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("shipper_id")
    private Long shipperId;

    @JsonProperty("shipper_name")
    private String shipperName;

    @JsonProperty("shipper_code")
    private String shipperCode;

    @JsonProperty("logistic_code")
    private String logisticCode;

    private String traces;

    @JsonProperty("is_finish")
    private Boolean isFinish;

    @JsonProperty("request_count")
    private Integer requestCount;

    @JsonProperty("request_time")
    private Integer requestTime;

    @JsonProperty("add_time")
    private Integer addTime;

    @JsonProperty("update_time")
    private Integer updateTime;

    @JsonProperty("express_type")
    private Boolean expressType;

    @JsonProperty("region_code")
    private String regionCode;

}