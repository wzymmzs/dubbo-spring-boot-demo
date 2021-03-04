package org.wzy.dubbo.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wzy.dubbo.DemoService;

@RestController

public class DefaultDemoAction {

    @DubboReference(version = "${demo.service.version}", check = false)
    private DemoService demoService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object test(String name) {
        try {
            return demoService.sayHello(name);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
