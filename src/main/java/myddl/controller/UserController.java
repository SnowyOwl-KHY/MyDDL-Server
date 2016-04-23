package myddl.controller;

import myddl.entity.UserInfo;
import myddl.returnobject.ReturnObject;
import myddl.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/user/{userId}")
    @ResponseBody
    public Object getUser(@PathVariable("userId") Long userId) {
        return ReturnObject.newOKReturnObject(userService.getUser(userId));
    }

    @RequestMapping(value = "/user/", method = RequestMethod.PUT)
    @ResponseBody
    public Object addUser(@RequestParam("nickname") String nickname) {
        userService.addUser(new UserInfo(nickname));
        return ReturnObject.EXECUTION_SUCCESS;
    }
}
