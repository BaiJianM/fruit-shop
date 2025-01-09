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
@Schema(description = "hiolabs_notice 表")
@TableName("hiolabs_notice")
public class Notice {

    private Long id;

    private String content;

    @JsonProperty("end_time")
    private Integer endTime;

    @JsonProperty("is_delete")
    private Boolean isDelete;

}