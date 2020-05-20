package cn.fyypumpkin.controller;

import cn.fyypumpkin.aop.Redirect;
import cn.fyypumpkin.assember.TransitoryAssember;
import cn.fyypumpkin.domain.result.TransitoryFetchResult;
import cn.fyypumpkin.dto.TransitoryFetchDTO;
import cn.fyypumpkin.response.Response;
import cn.fyypumpkin.service.TransitoryService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fyypumpkin on 3/25/20
 */
@RestController
public class TransitoryController {
    @Resource
    private TransitoryService transitoryService;

    /**
     * redirect
     */
    @RequestMapping("/pumpkin/{Param}")
    @ResponseBody
    @Redirect
    public Object fetch(@PathVariable("Param") String param, HttpServletResponse httpResponse) {
        TransitoryFetchResult fetch = transitoryService.fetch(TransitoryAssember.toDO(new TransitoryFetchDTO(param)));
        return Response.ok(TransitoryAssember.toDTO(fetch));
    }

    /**
     * redirect
     */
    @RequestMapping("/pumpkin/register")
    @ResponseBody
    public Object register(@RequestBody String message) {

        return Response.ok();
    }
}
