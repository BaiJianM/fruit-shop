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
@Schema(description = "hiolabs_show_settings 表")
@TableName("hiolabs_show_settings")
public class ShowSettings {

    private Long id;

    private Boolean banner;

    private Boolean channel;

    @JsonProperty("index_banner_img")
    private Boolean indexBannerImg;

    private Boolean notice;
}