package com.liyuyouguo.controller.shop;

import com.liyuyouguo.annotations.FruitShopController;
import com.liyuyouguo.beans.dto.shop.UserLoginDto;
import com.liyuyouguo.beans.vo.shop.UserLoginInfoVo;
import com.liyuyouguo.commons.FruitShopResponse;
import com.liyuyouguo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 验证控制层
 *
 * @author baijianmin
 */
@Slf4j
@FruitShopController("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    /**
     * 微信登录
     *
     * @param dto 小程序登录传参
     * @return UserLoginInfoVo 用户信息
     */
    @PostMapping("/loginByWeixin")
    public FruitShopResponse<UserLoginInfoVo> loginByWeChat(@RequestBody UserLoginDto dto) {
        return FruitShopResponse.success(userService.loginByWeChat(dto.getCode()));
    }

}
