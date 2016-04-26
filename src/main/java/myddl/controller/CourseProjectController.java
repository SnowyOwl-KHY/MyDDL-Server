package myddl.controller;

import myddl.constant.ErrorCode;
import myddl.constant.StatusCode;
import myddl.returnobject.CourseProjectRO;
import myddl.returnobject.ReturnObject;
import myddl.service.CourseProjectService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Component
@RequestMapping("/courseProject")
public class CourseProjectController {

    @Resource
    CourseProjectService courseProjectService;

    @RequestMapping("/{courseProjectId}")
    @ResponseBody
    public Object getCourseProject(@PathVariable("courseProjectId") Long courseProjectId) {
        CourseProjectRO result = courseProjectService.getCourseProject(courseProjectId);
        if (result != null) {
            return ReturnObject.newOKReturnObject(result);
        } else {
            return ReturnObject.newErrorReturnObject(StatusCode.GONE, ErrorCode.ERROR_COURSE_PROJECT_NOT_EXIST);
        }
    }

}
