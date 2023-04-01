package com.apktool.jpa.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserClassDo {
    private Integer userId;
    private String userName;
    private Integer userAge;
    private String userEmail;
    private String className;
}

