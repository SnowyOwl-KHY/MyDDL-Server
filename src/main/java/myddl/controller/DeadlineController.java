package myddl.controller;

import myddl.constant.ErrorCode;
import myddl.constant.StatusCode;
import myddl.returnobject.DeadlineRO;
import myddl.returnobject.ReturnObject;
import myddl.service.DeadlineService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Component
@RequestMapping("/deadline")
public class DeadlineController {

    @Resource
    DeadlineService deadlineService;

    @RequestMapping("/{deadlineId}")
    @ResponseBody
    public Object getDeadline(@PathVariable("deadlineId") Long deadlineId) {
        DeadlineRO result = deadlineService.getDeadline(deadlineId);
        if (result != null) {
            return ReturnObject.newOKReturnObject(result);
        } else {
            return ReturnObject.newErrorReturnObject(StatusCode.GONE, ErrorCode.ERROR_DEADLINE_NOT_EXIST);
        }
    }

    @RequestMapping(value = "/{deadlineId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteDeadline(@PathVariable("deadlineId") Long deadlineId) {
        deadlineService.deleteDeadline(deadlineId);
        return ReturnObject.EXECUTION_SUCCESS;
    }
}
