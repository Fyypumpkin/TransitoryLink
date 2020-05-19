package cn.fyypumpkin.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fyypumpkin on 3/25/20
 */
@RestController
public class TransitoryController {
    /**
     * redirect
     */
    @RequestMapping("/pumpkin/{Param}")
    @ResponseBody
    public void transitory(@PathVariable("Param") String param) {

    }
}
