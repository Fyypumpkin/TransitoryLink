package cn.fyypumpkin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fyypumpkin on 3/25/20
 */
@RestController
public class Test {
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "hello world";
    }
}
