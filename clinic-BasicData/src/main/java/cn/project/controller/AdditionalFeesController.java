package cn.project.controller;

import cn.project.service.additionalFeesService.AdditionalFeesService;
import cn.project.utils.Response;
import cn.project.utils.ResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "附加费用控制器")
@RequestMapping("additionalFees")
public class AdditionalFeesController {
    @Resource
    AdditionalFeesService additionalFeesService;

    @GetMapping("/getAllAdditionalFees")
    @ApiOperation(value = "获取所有附加费用")
    public Response getAllAdditionalFees(){
        return new Response(ResponseEnum.SUCCESS).setResponseBody(additionalFeesService.getAllAdditionalFees());
    }
}
