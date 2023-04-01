package com.apktool.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "sys_user")
@Entity
public class UserEntity extends BaseEntity {
    private String name;
    private Integer age;
    private String email;
}
