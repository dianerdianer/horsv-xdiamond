package com.horsv.controller;

import com.horsv.config.DemoConfigInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lzh
 * @description
 * @since 2018/3/23-下午3:50
 */
@RestController
public class SayHelloController {

    @Autowired
    private DemoConfigInstance demoInstanceConfig;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        return "hello everyone";
    }


    @RequestMapping(value = "/config",method = RequestMethod.GET)
    public String getConfig(){
        StringBuilder result = new StringBuilder();
        result.append("databaseUrl:").append(demoInstanceConfig.getDatabaseUrl()).append(";");
        result.append("memcachedAddress:").append(demoInstanceConfig.getMemcachedAddress()).append(";");
        result.append("zookeeperAddress:").append(demoInstanceConfig.getZookeeperAddress()).append(";");
        return result.toString();
    }

}
