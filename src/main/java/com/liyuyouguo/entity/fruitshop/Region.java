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
@Schema(description = "hiolabs_region 表")
@TableName("hiolabs_region")
public class Region {

    private Long id;

    @JsonProperty("parent_id")
    private Long parentId;

    private String name;

    private Integer type;

    @JsonProperty("agency_id")
    private Long agencyId;

    private Long area;

    @JsonProperty("area_code")
    private String areaCode;

    @JsonProperty("far_area")
    private Long farArea;
}