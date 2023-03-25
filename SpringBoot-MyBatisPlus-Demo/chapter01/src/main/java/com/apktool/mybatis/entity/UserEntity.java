package com.apktool.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@TableName(value = "sys_user")
public class UserEntity extends BaseEntity {
    private String name;
    private Integer age;
    private String email;
}
