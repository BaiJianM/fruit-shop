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
@Schema(description = "hiolabs_freight_template_detail 表")
@TableName("hiolabs_freight_template_detail")
public class FreightTemplateDetail {

    private Long id;

    @JsonProperty("template_id")
    private Integer templateId;

    @JsonProperty("group_id")
    private Integer groupId;

    private Integer area;

    @JsonProperty("is_delete")
    private Boolean isDelete;

}