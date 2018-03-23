package com.horsv.xdiamond.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * logback 配置及初始化
 */
public class LogbackEnvListener implements ServletContextListener {

  /**
   * ServletContext 初始化时进行logback.env配置加载
   * @param sce
   */
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    if (System.getProperty("logback.env") != null) {
      return;
    }

    String springProfileActive = System.getProperty("spring.profiles.active");
    if (springProfileActive != null && springProfileActive.contains("product")) {
      System.setProperty("logback.env", "product");
    }

    String contextSpringProfileActive =
        sce.getServletContext().getInitParameter("spring.profiles.active");
    if (contextSpringProfileActive != null && contextSpringProfileActive.contains("product")) {
      System.setProperty("logback.env", "product");
    }

    // 如果上面的配置都没有，则取spring default的，看Default里有没有product
    if (System.getProperty("logback.env") == null) {
      String contextSpringProfileDefault =
          sce.getServletContext().getInitParameter("spring.profiles.default");
      if (contextSpringProfileDefault != null && contextSpringProfileDefault.contains("product")) {
        System.setProperty("logback.env", "product");
      }
    }

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }
}
