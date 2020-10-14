package com.foodorder.inter.user.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSessionDto {

    private String userName;

    private Integer id;

    private String cookiePwd;

    private Integer userType;

}
