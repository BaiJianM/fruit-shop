package com.liyuyouguo.beans.vo.shop;

import com.liyuyouguo.entity.fruitshop.Order;
import lombok.Data;

/**
 * 订单数状态
 *
 * @author baijianmin
 */
@Data
public class OrderCountVo {

    private Long toPay;

    private Long toDelivery;

    private Long toReceive;

}
