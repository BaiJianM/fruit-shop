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
@Schema(description = "hiolabs_settings 表")
@TableName("hiolabs_settings")
public class Settings {

    private Long id;

    @JsonProperty("auto_delivery")
    private Boolean autoDelivery;

    private String name;

    private String tel;

    @JsonProperty("province_name")
    private String provinceName;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("exp_area_name")
    private String expAreaName;

    private String address;

    @JsonProperty("discovery_img_height")
    private Integer discoveryImgHeight;

    @JsonProperty("discovery_img")
    private String discoveryImg;

    @JsonProperty("goods_id")
    private Integer goodsId;

    @JsonProperty("city_id")
    private Integer cityId;

    @JsonProperty("province_id")
    private Integer provinceId;

    @JsonProperty("district_id")
    private Integer districtId;

    private Integer countdown;

    private Boolean reset;
}