package com.quant.beta.user.service.impl;

import com.quant.beta.user.entity.User;
import com.quant.beta.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> list = List.of(
            new User(1311L, "Dhruv Java", "23525625"),
            new User(1314L, "Durgesh Java", "888"),
            new User(1314L, "Jaydeep Java", "888")
    );

    @Override
    public User getUser(Long id) {
        return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }

}
