package com.apktool.jpa.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UserVo implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String email;
}