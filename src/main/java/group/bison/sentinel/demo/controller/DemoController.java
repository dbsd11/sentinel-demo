package group.bison.sentinel.demo.controller;

import group.bison.sentinel.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BSONG on 2019/6/30.
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public String test() {
        return demoService.test();
    }

    @RequestMapping("/test01")
    public String test01(@RequestParam(value = "tenantId", required = false, defaultValue = "0000000000") String tenantId) {
        return demoService.test01();
    }

    @RequestMapping("/test02")
    public String test02() {
        return demoService.test02();
    }

    @RequestMapping("/test03")
    public String test03() throws Exception {
        return demoService.test03();
    }


}
