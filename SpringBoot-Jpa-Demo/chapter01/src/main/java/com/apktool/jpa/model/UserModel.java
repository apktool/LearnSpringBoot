package com.apktool.jpa.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UserModel extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Size(min = 2, max = 10, message = "user name should have at least 2 characters")
    private String name;

    @Min(value = 1)
    @Max(value = 100)
    private Integer age;

    @Email
    private String email;
}
