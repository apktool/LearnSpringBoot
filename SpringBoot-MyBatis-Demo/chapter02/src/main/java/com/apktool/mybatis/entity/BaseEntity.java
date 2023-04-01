package com.apktool.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

public abstract class BaseEntity {
    @Setter
    @Getter
    protected Integer id;
}