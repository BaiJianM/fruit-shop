package com.liyuyouguo.beans.vo.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.liyuyouguo.entity.fruitshop.Goods;
import lombok.Data;

import java.util.List;

/**
 * @author baijianmin
 */
@Data
public class CategoryVo {
    private Long id;

    private String name;

    private String keywords;

    @JsonProperty("front_desc")
    private String frontDesc;

    @JsonProperty("parent_id")
    private Integer parentId;

    @JsonProperty("sort_order")
    private Integer sortOrder;

    @JsonProperty("show_index")
    private Integer showIndex;

    @JsonProperty("is_show")
    private Boolean isShow;

    @JsonProperty("icon_url")
    private String iconUrl;

    @JsonProperty("img_url")
    private String imgUrl;

    private String level;

    @JsonProperty("front_name")
    private String frontName;

    @JsonProperty("p_height")
    private Integer pHeight;

    @JsonProperty("is_category")
    private Boolean isCategory;

    @JsonProperty("is_channel")
    private Boolean isChannel;

    private List<Goods> goodsList;
}
