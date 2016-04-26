package myddl.controller;

import myddl.constant.ErrorCode;
import myddl.constant.StatusCode;
import myddl.entity.Group;
import myddl.returnobject.GroupRO;
import myddl.returnobject.ReturnObject;
import myddl.service.GroupService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/{groupId}", method = RequestMethod.POST)
    @ResponseBody
    public Object modifyGroup(@PathVariable("groupId") Long groupId,
                              @RequestParam(value = "groupName", required = false) String groupName,
                              @RequestParam(value = "groupImage", required = false) String groupImage) {
        groupService.modifyGroup(new Group(groupId, groupName, groupImage));
        return ReturnObject.EXECUTION_SUCCESS;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Object addGroup(@RequestParam("groupName") String groupName,
                           @RequestParam("groupImage") String groupImage) {
        Long groupId = groupService.addGroup(new Group(null, groupName, groupImage));
        Map<String, Object> result = new HashMap<>();
        result.put("groupId", groupId);
        return ReturnObject.newOKReturnObject(result);
    }

    @RequestMapping(value = "/{groupId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteGroup(@PathVariable("groupId") Long groupId) {
        groupService.deleteGroup(groupId);
        return ReturnObject.EXECUTION_SUCCESS;
    }

    @RequestMapping(value = "/{groupId}/user/{userId}", method = RequestMethod.PUT)
    @ResponseBody
    public Object addGroupUser(@PathVariable("groupId") Long groupId,
                               @PathVariable("userId") Long userId) {
        groupService.addGroupUser(groupId, userId);
        return ReturnObject.EXECUTION_SUCCESS;
    }

}
