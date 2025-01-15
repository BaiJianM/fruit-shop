package com.liyuyouguo.commons;

/**
 * 业务异常枚举类
 *
 * @author baijianmin
 */
public enum ShopError implements ErrorResponse<Integer> {

    // 业务相关异常提示
    INDEX_ERROR(1001, "首页分类数据转换失败"),
    WECHAT_LOGIN_ERROR(1002, "微信登录失败"),
    GOODS_NOT_EXIST(1003, "该商品不存在或已下架"),
    SKU_ERROR(1004, "规格信息转换失败"),
    CART_EMPTY(1005, "购物车为空"),
    INSUFFICIENT_STOCK(1006, "库存不足"),
    ITEM_NOT_AVAILABLE(1007, "商品已下架"),
    CART_ITEM_NOT_EXIST(1008, "购物车商品不存在"),
    INVALID_CART_OPERATION(1009, "不支持的购物车操作"),
    PRODUCT_ID_NOT_EMPTY(1010, "商品id不能为空"),
    ;

    /**
     * 异常状态码
     */
    private final Integer code;

    /**
     * 异常描述
     */
    private final String describe;

    ShopError(Integer code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDescribe() {
        return describe;
    }


}
