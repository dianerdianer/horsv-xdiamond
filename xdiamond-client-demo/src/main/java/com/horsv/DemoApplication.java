package com.horsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 *
 * @author lzh
 * @description
 * @since 2018/3/23-下午3:43
 */

//@SpringBootApplication使用了@EnableAutoConfiguration、@ComponentScan和@Configuration,
// 使用这一个注解即可代替@EnableAutoConfiguration + @Configuration + @ComponentScan
@SpringBootApplication
//启动类放在项目顶级路径(com.horsv)下，使用@EnableAutoConfiguration会隐式的定义了一个basePackage(即顶级目录com.horsv)
//@EnableAutoConfiguration
//使用ComponentScan可以进行basePackages的设置
//@ComponentScan
public class DemoApplication {

    public static void main(String[] args) {
        //启动应用
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class,args);

    }

}
