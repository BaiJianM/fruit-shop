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
