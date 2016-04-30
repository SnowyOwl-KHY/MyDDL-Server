package myddl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {

    @Autowired
    private HttpServletRequest request;

    protected Long getUserId() {
        return Long.parseLong(request.getParameter("userId"));
    }

}
