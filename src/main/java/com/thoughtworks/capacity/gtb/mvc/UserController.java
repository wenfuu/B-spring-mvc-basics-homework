package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user) {
        userService.register(user);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam @NotBlank(message = "用户名不为空") @Pattern(regexp = "^[_a-zA-Z0-9]+$", message = "用户名不合法") @Size(min = 3, max = 10, message = "用户名不合法") String username, @RequestParam @NotBlank(message = "密码不为空") @Size(min = 5, max = 12, message = "密码不合法") String password) {
        return userService.login(username, password);
    }
}
