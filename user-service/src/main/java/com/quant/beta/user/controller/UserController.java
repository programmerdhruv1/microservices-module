package com.quant.beta.user.controller;

import com.quant.beta.user.entity.User;
import com.quant.beta.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
//
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {

        User user = this.userService.getUser(userId);
        //http://localhost:9002/contact/user/1311

        List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);


        user.setContacts(contacts);
        return user;

    }

    public static void main(String[] args) {
        boolean a = false;
        int b = 0;
        String c = "A";

        if(!a || b ==1 || c.equalsIgnoreCase("b")){
            System.out.println("Test");
        }
    }

}
