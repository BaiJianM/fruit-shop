package com.liyuyouguo.entity.fruitshop;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地址信息表
 *
 * @author baijianmin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "address表")
@TableName("hiolabs_address")
public class Address {

    private Long id;

    @Schema(description = "unknown", example = "1")
    private String name;

    @Schema(description = "unknown", example = "1")
    @JsonProperty("user_id")
    private Long userId;

    @Schema(description = "unknown", example = "1")
    @JsonProperty("country_id")
    private Long countryId;

    @Schema(description = "unknown", example = "1")
    @JsonProperty("province_id")
    private Long provinceId;

    @Schema(description = "unknown", example = "1")
    @JsonProperty("city_id")
    private Long cityId;

    @Schema(description = "unknown", example = "1")
    @JsonProperty("district_id")
    private Long districtId;

    @Schema(description = "unknown", example = "1")
    private String address;

    @Schema(description = "unknown", example = "1")
    private String mobile;

    @Schema(description = "unknown", example = "1")
    @JsonProperty("is_default")
    private Boolean isDefault;

    @Schema(description = "unknown", example = "1")
    @JsonProperty("is_delete")
    private Boolean isDelete;

}