package myddl.controller;

import myddl.constant.ErrorCode;
import myddl.constant.StatusCode;
import myddl.entity.Deadline;
import myddl.returnobject.DeadlineRO;
import myddl.returnobject.ReturnObject;
import myddl.service.DeadlineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
@RequestMapping("/deadline")
public class DeadlineController {

    @Resource
    private DeadlineService deadlineService;

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

    @RequestMapping(value = "/{deadlineId}", method = RequestMethod.POST)
    @ResponseBody
    public Object modifyDeadline(@PathVariable("deadlineId") Long deadlineId,
                                 @RequestParam(value = "deadlineName", required = false) String deadlineName,
                                 @RequestParam(value = "time", required = false) String time,
                                 @RequestParam(value = "courseProjectId", required = false) Long courseProjectId,
                                 @RequestParam(value = "contactName", required = false) String contactName,
                                 @RequestParam(value = "contactPhone", required = false) String contactPhone,
                                 @RequestParam(value = "contactEmail", required = false) String contactEmail,
                                 @RequestParam(value = "deadlineNote", required = false) String deadlineNote,
                                 @RequestParam(value = "deadlineImage", required = false) String deadlineImage,
                                 @RequestParam(value = "complete", required = false) Boolean complete) {
        deadlineService.modifyDeadline(new Deadline(deadlineId, deadlineName, time, courseProjectId, contactName, contactPhone, contactEmail, deadlineNote, deadlineImage, complete));
        return ReturnObject.EXECUTION_SUCCESS;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Object addDeadline(@RequestParam("deadlineName") String deadlineName,
                              @RequestParam("time") String time,
                              @RequestParam("courseProjectId") Long courseProjectId,
                              @RequestParam("userId") Long userId,
                              @RequestParam(value = "contactName", required = false) String contactName,
                              @RequestParam(value = "contactPhone", required = false) String contactPhone,
                              @RequestParam(value = "contactEmail", required = false) String contactEmail,
                              @RequestParam(value = "deadlineNote", required = false) String deadlineNote,
                              @RequestParam(value = "deadlineImage", required = false) String deadlineImage,
                              @RequestParam(value = "complete", required = false) Boolean complete) {
        long deadlineId = deadlineService.addDeadline(
                new Deadline(null, deadlineName, time, courseProjectId, contactName, contactPhone, contactEmail, deadlineNote, deadlineImage, complete),
                userId);
        HashMap<String, Long> result = new HashMap<>();
        result.put("deadlineId", deadlineId);
        return ReturnObject.newOKReturnObject(result);
    }

    @RequestMapping(value = "/{deadlineId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteDeadline(@PathVariable("deadlineId") Long deadlineId) {
        deadlineService.deleteDeadline(deadlineId);
        return ReturnObject.EXECUTION_SUCCESS;
    }
}
