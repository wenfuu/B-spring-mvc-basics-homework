package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotBlank(message = "用户名不为空")
    @Pattern(regexp = "^[_a-zA-Z0-9]+$", message = "用户名不合法")
    @Size(min = 3, max = 10, message = "用户名不合法")
    private String username;

    @NotBlank(message = "密码不为空")
    @Size(min = 5, max = 12, message = "密码不合法")
    private String password;

    @Email(message = "邮箱地址不合法")
    private String email;
}
