package com.thoughtworks.capacity.gtb.mvc;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final Map<Integer, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put(1, new User("user1", "psw1", "email1@test.com"));
        userMap.put(2, new User("user2", "psw2", "email2@test.com"));
    }

    public void register(User user) {
        List<User> registerUser = userMap.values().stream().filter(u -> u.getUsername().equals(user.getUsername())).collect(Collectors.toList());
        if (!registerUser.isEmpty()) {
            throw new UserExistException("用户已存在");
        } else {
            userMap.put((userMap.size() + 1), user);
        }
    }

    public User login(String username, String password) {
        List<User> loginUser = userMap.values().stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).collect(Collectors.toList());
        if (loginUser.isEmpty()) {
            throw new UserInvalidException("用户名或密码错误");
        } else {
            return loginUser.get(0);
        }
    }
}
