package com.liyuyouguo.service;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liyuyouguo.beans.vo.shop.UserLoginInfoVo;
import com.liyuyouguo.commons.FruitShopException;
import com.liyuyouguo.commons.ShopError;
import com.liyuyouguo.entity.fruitshop.User;
import com.liyuyouguo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

/**
 * 用户信息服务类
 *
 * @author baijianmin
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    private final WxMaService wxMaService;

    /**
     * 微信登录
     *
     * @param code 登录时的jsCode
     * @return UserRegisterInfoVo 用户信息
     */
    public UserLoginInfoVo loginByWeChat(String code) {
        // 调用微信小程序登录接口
        WxMaJscode2SessionResult sessionResult;
        try {
            sessionResult = wxMaService.jsCode2SessionInfo(code);
        } catch (WxErrorException e) {
            log.error("微信小程序登录失败: ", e);
//            throw new FruitShopException(ShopError.WECHAT_LOGIN_ERROR);
            return null;
        }
        String openId = sessionResult.getOpenid();
        // 查找用户是否已注册
        User user = userMapper.selectOne(Wrappers.lambdaQuery(User.class)
                .eq(User::getWeixinOpenid, openId));
        boolean isNew = false;
        if (user == null) {
            String wxName = "微信用户";
            User newUser = new User();
            newUser.setUsername(wxName + UUID.randomUUID());
            newUser.setPassword(openId);
            newUser.setRegisterTime(LocalDateTime.now());
            newUser.setRegisterIp("");
            newUser.setLastLoginTime(LocalDateTime.now());
            newUser.setLastLoginIp("");
            newUser.setMobile("");
            newUser.setWeixinOpenid(openId);
            newUser.setNickname(Base64.getEncoder().encodeToString(wxName.getBytes()));
            newUser.setAvatar("/static/images/default_avatar.png");
            userMapper.insert(newUser);
            user = newUser;
            isNew = true;
        }
        UserLoginInfoVo registerInfoVo = new UserLoginInfoVo();
        registerInfoVo.setUserInfo(user);
        registerInfoVo.setIsNew(isNew);
        // TODO 少一个token生成逻辑
        registerInfoVo.setToken("");
        return registerInfoVo;
    }

}
