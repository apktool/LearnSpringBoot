package com.apktool.mybatis.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UserClassVo implements Serializable {
    private Integer userId;

    private String userName;

    private Integer userAge;

    private String userEmail;

    private String className;
}