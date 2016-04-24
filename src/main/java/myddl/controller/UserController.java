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

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public Object addUser(@RequestParam("userName") String userName,
                          @RequestParam(value = "userImage", required = false) String userImage,
                          @RequestParam(value = "userPhone", required = false) String userPhone,
                          @RequestParam(value = "userEmail", required = false) String userEmail,
                          @RequestParam("mainScreenImage") Integer mainScreenImage) {
        userService.addUser(new UserInfo(null, userName, userImage, userPhone, userEmail, mainScreenImage));
        return ReturnObject.EXECUTION_SUCCESS;
    }
}
