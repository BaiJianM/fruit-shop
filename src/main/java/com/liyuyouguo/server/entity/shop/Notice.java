package com.liyuyouguo.server.entity.shop;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author baijianmin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "hiolabs_notice 表")
@TableName("hiolabs_notice")
public class Notice {

    private Integer id;

    private String content;

    @JsonProperty("end_time")
    private LocalDateTime endTime;

    @JsonProperty("is_delete")
    private Integer isDelete;

}