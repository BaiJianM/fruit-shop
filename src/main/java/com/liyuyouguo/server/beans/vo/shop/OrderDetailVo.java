package com.liyuyouguo.server.beans.vo.shop;

import com.liyuyouguo.server.entity.shop.OrderGoods;
import lombok.Data;

import java.util.List;

/**
 * 订单详情
 *
 * @author baijianmin
 */
@Data
public class OrderDetailVo {

    private OrderInfoVo orderInfo;

    private List<OrderGoods> orderGoods;

    private OrderHandleOptionVo handleOption;

    private OrderTextCodeVo textCode;

    private Integer goodsCount;

}
