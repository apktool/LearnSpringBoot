package com.apktool.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "sys_class")
@Entity
public class ClassEntity extends BaseEntity {
    private String name;
    private String desc;
}
