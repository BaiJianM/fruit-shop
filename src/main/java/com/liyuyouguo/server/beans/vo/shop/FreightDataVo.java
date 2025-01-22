package com.liyuyouguo.server.beans.vo.shop;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baijianmin
 */
@Data
public class FreightDataVo {

    private Integer id;

    private Integer number;

    private BigDecimal money;

    private Double goodsWeight;

    private Integer freightType;

}
