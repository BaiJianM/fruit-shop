package com.liyuyouguo.service.shop;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liyuyouguo.beans.vo.shop.CartCountVo;
import com.liyuyouguo.beans.vo.shop.CartInfoVo;
import com.liyuyouguo.beans.vo.shop.CartTotalVo;
import com.liyuyouguo.beans.vo.shop.CartVo;
import com.liyuyouguo.commons.FruitShopException;
import com.liyuyouguo.commons.ShopError;
import com.liyuyouguo.entity.fruitshop.Cart;
import com.liyuyouguo.entity.fruitshop.Goods;
import com.liyuyouguo.entity.fruitshop.Product;
import com.liyuyouguo.mapper.CartMapper;
import com.liyuyouguo.mapper.GoodsMapper;
import com.liyuyouguo.mapper.ProductMapper;
import com.liyuyouguo.utils.ConvertUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车服务类
 *
 * @author baijianmin
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CartService {

    private final CartMapper cartMapper;

    private final ProductMapper productMapper;

    private final GoodsMapper goodsMapper;

    /**
     * 获取购物车商品的总件件数
     *
     * @return CartVo 购物车数量
     */
    public CartCountVo getGoodsCount() {
        CartCountVo cartCountVo = new CartCountVo();
        CartInfoVo cartInfo = this.getCart(0);
        if (cartInfo == null) {
            CartTotalVo cartTotalVo = new CartTotalVo();
            cartTotalVo.setGoodsCount(0);
            cartCountVo.setCartTotal(cartTotalVo);
            return cartCountVo;
        }
        Cart cart = cartMapper.selectOne(Wrappers.lambdaQuery(Cart.class)
                .eq(Cart::getUserId, cartInfo.getCartTotal().getUserId())
                .eq(Cart::getIsDelete, 0)
                .eq(Cart::getIsFast, 1));
        cart.setIsDelete(1);
        cartMapper.updateById(cart);
        cartCountVo.setCartTotal(cartInfo.getCartTotal());
        return cartCountVo;
    }

    public CartInfoVo getCart(Integer isFast) {
        // TODO 这里少一个从token获取登录人id的操作
        Integer userId = 1048;
        List<Cart> carts = cartMapper.selectList(Wrappers.lambdaQuery(Cart.class)
                .eq(Cart::getUserId, userId)
                .eq(Cart::getIsDelete, 0)
                .eq(Cart::getIsFast, isFast));
        if (carts.isEmpty()) {
            return null;
        }
        int goodsCount = 0;
        BigDecimal goodsAmount = new BigDecimal(0);
        int checkedGoodsCount = 0;
        BigDecimal checkedGoodsAmount = new BigDecimal(0);
        int numberChange = 0;
        List<CartVo> cartList = new ArrayList<>();
        for (Cart cart : carts) {
            CartVo cartVo = ConvertUtils.convert(cart, CartVo::new).orElseThrow();
            Product product = productMapper.selectById(cart.getProductId());
            if (product == null) {
                cart.setIsDelete(1);
                cartMapper.updateById(cart);
            } else {
                BigDecimal retailPrice = product.getRetailPrice();
                Integer productNum = product.getGoodsNumber();
                if (productNum <= 0 || product.getIsOnSale() == 0) {
                    cart.setChecked(0);
                    cartMapper.updateById(cart);
                    cartVo.setNumber(0);
                } else if (productNum > 0 && productNum < cart.getNumber()) {
                    cartVo.setNumber(productNum);
                    numberChange = 1;
                } else if (productNum > 0 && cart.getNumber() == 0) {
                    cartVo.setNumber(1);
                    numberChange = 1;
                }
                goodsCount += cart.getNumber();
                goodsAmount = goodsAmount.add(retailPrice.multiply(new BigDecimal(cart.getNumber())));
                cartVo.setRetailPrice(retailPrice);
                // TODO 这个if有待验证
                if (cart.getChecked() == 1 && productNum > 0) {
                    checkedGoodsCount += cart.getNumber();
                    checkedGoodsAmount = checkedGoodsAmount.add(retailPrice.multiply(new BigDecimal(cart.getNumber())));
                }
                // 查找商品的图片
                Goods goods = goodsMapper.selectById(cart.getGoodsId());
                cartVo.setListPicUrl(goods.getListPicUrl());
                cartVo.setWeightCount(cartVo.getNumber() * cartVo.getGoodsWeight());

                cart.setNumber(cartVo.getNumber());
                cart.setAddPrice(retailPrice);
                cartMapper.updateById(cart);
            }
            cartList.add(cartVo);
        }
        CartInfoVo cartInfoVo = new CartInfoVo();
        cartInfoVo.setCartList(cartList);

        CartTotalVo cartTotalVo = new CartTotalVo();
        cartTotalVo.setGoodsCount(goodsCount);
        cartTotalVo.setGoodsAmount(goodsAmount.setScale(2, RoundingMode.DOWN));
        cartTotalVo.setCheckedGoodsCount(checkedGoodsCount);
        cartTotalVo.setCheckedGoodsAmount(checkedGoodsAmount.setScale(2, RoundingMode.DOWN));
        cartTotalVo.setUserId(userId);
        cartTotalVo.setNumberChange(numberChange);

        cartInfoVo.setCartTotal(cartTotalVo);
        return cartInfoVo;
    }

    /**
     * 获取购物车信息，所有对购物车的增删改操作，都要重新返回购物车的信息
     *
     * @return CartInfoVo 购物车信息
     */
    public CartInfoVo getIndex() {
        return this.getCart(0);
    }
}
