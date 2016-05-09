package myddl.controller;

import myddl.constant.ErrorCode;
import myddl.constant.StatusCode;
import myddl.entity.CourseProject;
import myddl.returnobject.CourseProjectRO;
import myddl.returnobject.ReturnObject;
import myddl.service.CourseProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
@RequestMapping("/courseProject")
public class CourseProjectController {

    @Resource
    private CourseProjectService courseProjectService;

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

    @RequestMapping(value = "/{courseProjectId}", method = RequestMethod.POST)
    @ResponseBody
    public Object modifyCourseProject(@PathVariable("courseProjectId") Long courseProjectId,
                                      @RequestParam(value = "courseProjectName", required = false) String courseProjectName,
                                      @RequestParam(value = "courseProjectType", required = false) String courseProjectType,
                                      @RequestParam(value = "courseProjectNote", required = false) String courseProjectNote,
                                      @RequestParam(value = "courseProjectImage", required = false) String courseProjectImage) {
        courseProjectService.modifyCourseProject(
                new CourseProject(courseProjectId, courseProjectName, courseProjectType, courseProjectNote, courseProjectImage));
        return ReturnObject.EXECUTION_SUCCESS;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Object addCourseProject(@RequestParam("userId") Long userId,
                                   @RequestParam("courseProjectName") String courseProjectName,
                                   @RequestParam("courseProjectType") String courseProjectType,
                                   @RequestParam(value = "courseProjectNote", required = false) String courseProjectNote,
                                   @RequestParam(value = "courseProjectImage", required = false) String courseProjectImage) {
        long courseProjectId = courseProjectService.addCourseProject(
                new CourseProject(null, courseProjectName, courseProjectType, courseProjectNote, courseProjectImage),
                userId);
        HashMap<String, Long> result = new HashMap<>();
        result.put("courseProjectId", courseProjectId);
        return ReturnObject.newOKReturnObject(result);
    }

    @RequestMapping(value = "/{courseProjectId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteCourseProject(@PathVariable("courseProjectId") Long courseProjectId) {
        courseProjectService.deleteCourseProject(courseProjectId);
        return ReturnObject.EXECUTION_SUCCESS;
    }

}
