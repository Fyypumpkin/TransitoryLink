package cn.fyypumpkin.controller;

import cn.fyypumpkin.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@RestController
public class ErrorController {
    /**
     * redirect
     */
    @RequestMapping("/pumpkin/404")
    @ResponseBody
    public Object error() {
        return Response.failed("您访问的资源不存在");
    }
}
