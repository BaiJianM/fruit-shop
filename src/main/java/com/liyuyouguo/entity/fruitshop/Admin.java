package com.liyuyouguo.entity.fruitshop;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author baijianmin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "admin表")
@TableName("hiolabs_admin")
public class Admin {

    private Long id;

    @Schema(description = "账号名", example = "1")
    @JsonProperty("username")
    private String username;

    @Schema(description = "密码", example = "1")
    @JsonProperty("password")
    private String password;

    @Schema(description = "密码加密盐", example = "1")
    @JsonProperty("password_salt")
    private String passwordSalt;

    @Schema(description = "最后登录的IP", example = "1")
    @JsonProperty("last_login_ip")
    private String lastLoginIp;

    @Schema(description = "最后登录时间", example = "1")
    @JsonProperty("last_login_time")
    private Long lastLoginTime;

    @Schema(description = "unknown", example = "1")
    @JsonProperty("is_delete")
    private Boolean isDelete;

}