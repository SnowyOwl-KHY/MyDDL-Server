package myddl.controller;

import myddl.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/user/{userId}")
    @ResponseBody
    public Object getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }
}
