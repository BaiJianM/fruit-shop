package com.liyuyouguo.beans.vo.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.liyuyouguo.entity.fruitshop.Goods;
import com.liyuyouguo.entity.fruitshop.OrderGoods;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author baijianmin
 */
@Data
public class OrderVo {

    private Integer id;

    private List<OrderGoods> goodsList;

    private Integer goodsCount;

    @JsonProperty("add_time")
    private String addTime;

    @JsonProperty("order_status_text")
    private String orderStatusText;

    private OrderHandleOptionVo handleOption;

}
