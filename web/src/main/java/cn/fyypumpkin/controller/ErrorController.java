package cn.fyypumpkin.controller;

import cn.fyypumpkin.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Controller
public class ErrorController {
    /**
     * redirect
     */
    @GetMapping("/pumpkin/404")
    public String error() {
        return Response.failed();
    }
}
