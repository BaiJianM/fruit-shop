package com.liyuyouguo.beans.vo.shop;

import com.liyuyouguo.entity.fruitshop.Cart;
import lombok.Data;

import java.util.List;

/**
 * 购物车信息
 *
 * @author baijianmin
 */
@Data
public class CartInfoVo {

    private List<CartVo> cartList;

    private CartTotalVo cartTotal;

}
