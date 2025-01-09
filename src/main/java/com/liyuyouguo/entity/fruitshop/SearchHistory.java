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
@Schema(description = "hiolabs_search_history 表")
@TableName("hiolabs_search_history")
public class SearchHistory {

    private Long id;

    private String keyword;

    private String from;

    @JsonProperty("add_time")
    private Long addTime;

    @JsonProperty("user_id")
    private String userId;
}