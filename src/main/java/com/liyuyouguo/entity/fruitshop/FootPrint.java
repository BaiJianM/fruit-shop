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
@Schema(description = "hiolabs_footprint 表")
@TableName("hiolabs_footprint")
public class FootPrint {

    private Long id;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("goods_id")
    private Integer goodsId;

    @JsonProperty("add_time")
    private Integer addTime;

}