package com.horsv.config;

import com.horsv.xdiamond.client.XDiamondConfig;
import com.horsv.xdiamond.client.spring.PropertySourcesAdderBean;
import com.horsv.xdiamond.client.spring.XDiamondConfigFactoryBean;
import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Properties;

/**
 * @author lzh
 * @description
 * @since 2018/3/25-上午11:07
 */
@Configuration
@Data
public class XDiamondInitConfig{

    /**
     * 初始化xdiamondConfigBean
     * @return
     */
    @Bean(name = "xDiamondConfig")
    public XDiamondConfigFactoryBean xDiamondConfigFactoryBean(){
        XDiamondConfigFactoryBean config = new XDiamondConfigFactoryBean();
        return config;
    }


    /**
     * 初始化PropertyPlaceholderConfigurer
     * 使用这种方式加载xDiamondConfig管理的配置，如果xDiamondConfig中没有配置的配置就会报错
     * @return
     * @throws Exception
     */
//    @Bean
//    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer(WebApplicationContext context) throws Exception {
//        PropertyPlaceholderConfigurer configer = new PropertyPlaceholderConfigurer();
//
//        //使用XDiamondConfig管理Properties对象
//        XDiamondConfig xDiamondConfig = this.xDiamondConfigFactoryBean().getObject();
//        Properties properties = xDiamondConfig.getProperties();
//        configer.setProperties(properties);
//
////      指定location可以加载本地配置
////        Resource location = context.getResource("classpath:application.properties") ;
////        configer.setLocation(location);
//        return configer;
//    }


    /**
     * 使用xDiamondConfig加载配置
     * 使用这种方式加载xDiamondConfig管理的配置，如果xDiamondConfig中没有配置的配置,可以查看本地配置文件是否存在
     * 优先本地配置
     * @return
     * @throws Exception
     */
    @Bean
    public PropertySourcesAdderBean PropertySourcesAdderBean() throws Exception {

        PropertySourcesAdderBean propertySources = new PropertySourcesAdderBean();

        //使用XDiamondConfig管理Properties对象
        XDiamondConfig xDiamondConfig = this.xDiamondConfigFactoryBean().getObject();
        Properties properties = xDiamondConfig.getProperties();
        propertySources.setProperties(properties);

        return propertySources;
    }
}
