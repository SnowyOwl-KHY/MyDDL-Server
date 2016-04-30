package myddl.controller;

import myddl.constant.ErrorCode;
import myddl.constant.StatusCode;
import myddl.entity.UserInfo;
import myddl.returnobject.ReturnObject;
import myddl.returnobject.UserRO;
import myddl.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/{userId}")
    @ResponseBody
    public Object getUser(@PathVariable("userId") Long userId) {
        UserRO userRO = userService.getUser(userId);
        if (userRO != null) {
            return ReturnObject.newOKReturnObject(userRO);
        } else {
            return ReturnObject.newErrorReturnObject(StatusCode.GONE, ErrorCode.ERROR_USER_NOT_EXIST);
        }
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public Object modifyUser(@PathVariable("userId") Long userId,
                             @RequestParam(value = "userName", required = false) String userName,
                             @RequestParam(value = "userImage", required = false) String userImage,
                             @RequestParam(value = "userPhone", required = false) String userPhone,
                             @RequestParam(value = "userEmail", required = false) String userEmail,
                             @RequestParam(value = "mainScreenImage", required = false) Integer mainScreenImage) {
        userService.modifyUser(new UserInfo(userId, userName, userImage, userPhone, userEmail, mainScreenImage));
        return ReturnObject.EXECUTION_SUCCESS;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Object addUser(@RequestParam("userName") String userName,
                          @RequestParam(value = "userImage", required = false) String userImage,
                          @RequestParam(value = "userPhone", required = false) String userPhone,
                          @RequestParam(value = "userEmail", required = false) String userEmail,
                          @RequestParam("mainScreenImage") Integer mainScreenImage) {
        long userId = userService.addUser(new UserInfo(null, userName, userImage, userPhone, userEmail, mainScreenImage));
        Map<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        return ReturnObject.newOKReturnObject(result);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ReturnObject.EXECUTION_SUCCESS;
    }
}
