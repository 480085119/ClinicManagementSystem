package cn.project.controller;

import cn.project.entity.Prescription_AdditionalFees;
import cn.project.service.additionalFeesService.AdditionalFeesService;
import cn.project.utils.Response;
import cn.project.utils.ResponseEnum;
import com.alibaba.druid.filter.config.ConfigTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static com.alibaba.druid.filter.config.ConfigTools.encrypt;

//你好啊
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

    @GetMapping("/addAdditionalFees")
    @ApiOperation(value = "新增附加费用")
    public Response getAllAdditionalFees(Prescription_AdditionalFees prescription_additionalFees){
        additionalFeesService.addAdditionalFees(prescription_additionalFees);
        return new Response(ResponseEnum.SUCCESS);
    }

//    public static void main(String[] args) {
//        ConfigTools configTools = new ConfigTools();
//        String password = "123456";
//        String[] arr = new String[2];
//        try {
//            arr = configTools.genKeyPair(512);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        }
//        System.out.println("privateKey:" + arr[0]);
//        System.out.println("publicKey:" + arr[1]);
//        try {
//            String pa = configTools.encrypt(arr[0], password);
//            System.out.println("password:" + pa);
//            System.out.println("password22:"+ConfigTools.decrypt(arr[1], pa));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
