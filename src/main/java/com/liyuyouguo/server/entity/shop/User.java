package com.liyuyouguo.server.entity.shop;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author baijianmin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "hiolabs_user 表")
@TableName("hiolabs_user")
public class User {

    private Integer id;

    private String nickname;

    private String name;

    private String username;

    private String password;

    private Integer gender;

    private Integer birthday;

    @JsonProperty("register_time")
    private LocalDateTime registerTime;

    @JsonProperty("last_login_time")
    private LocalDateTime lastLoginTime;

    @JsonProperty("last_login_ip")
    private String lastLoginIp;

    private String mobile;

    @JsonProperty("register_ip")
    private String registerIp;

    private String avatar;

    @JsonProperty("weixin_openid")
    private String weixinOpenid;

    @JsonProperty("name_mobile")
    private Integer nameMobile;

    private String country;

    private String province;

    private String city;
}