package myddl.controller;

import myddl.constant.ErrorCode;
import myddl.constant.StatusCode;
import myddl.returnobject.GroupRO;
import myddl.returnobject.ReturnObject;
import myddl.service.GroupService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Component
@RequestMapping("/group")
public class GroupController {

    @Resource
    GroupService groupService;

    @RequestMapping("/{groupId}")
    @ResponseBody
    public Object getGroup(@PathVariable("groupId") Long groupId) {
        GroupRO result = groupService.getGroup(groupId);
        if (result != null) {
            return ReturnObject.newOKReturnObject(result);
        } else {
            return ReturnObject.newErrorReturnObject(StatusCode.GONE, ErrorCode.ERROR_GROUP_NOT_EXIST);
        }
    }

}
