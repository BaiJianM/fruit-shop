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
@Schema(description = "hiolabs_formid 表")
@TableName("hiolabs_formid")
public class FormId {

    private Long id;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("form_id")
    private String formId;

    @JsonProperty("add_time")
    private Integer addTime;

    @JsonProperty("use_times")
    private Boolean useTimes;

}