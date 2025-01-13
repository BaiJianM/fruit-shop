package com.liyuyouguo.controller.shop;

import com.liyuyouguo.annotations.FruitShopController;
import com.liyuyouguo.commons.FruitShopResponse;
import com.liyuyouguo.entity.fruitshop.ShowSettings;
import com.liyuyouguo.entity.fruitshop.User;
import com.liyuyouguo.service.UserService;
import com.liyuyouguo.service.shop.ShowSettingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 显示配置控制层
 *
 * @author baijianmin
 */
@Slf4j
@FruitShopController("/settings")
@RequiredArgsConstructor
public class ShowSettingsController {

    private final ShowSettingsService showSettingsService;

    private final UserService userService;

    /**
     * 获取显示配置
     *
     * @return ShowSettings 首页显示配置实体类
     */
    @GetMapping("/showSettings")
    public FruitShopResponse<ShowSettings> showSettings() {
        return FruitShopResponse.success(showSettingsService.getShowSettings());
    }

    /**
     * 获取登录用户信息
     *
     * @return User 登录用户信息
     */
    @GetMapping("/userDetail")
    public FruitShopResponse<User> getUserDetail() {
        return FruitShopResponse.success(userService.getUserDetail());
    }

}
