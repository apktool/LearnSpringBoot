package com.apktool.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

public abstract class BaseEntity {
    @Setter
    @Getter
    @TableId(type = IdType.ASSIGN_ID)
    protected Integer id;
}