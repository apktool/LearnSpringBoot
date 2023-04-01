package com.apktool.jpa.entity;

import jakarta.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassEntity clazz;
}
