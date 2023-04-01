package com.apktool.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserClassEntity extends BaseEntity {
    private Integer userId;
    private String userName;
    private Integer userAge;
    private String userEmail;
    private String className;
}