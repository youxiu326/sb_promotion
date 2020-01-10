package com.youxiu326.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import javax.servlet.ServletContext;

@Component
public class ContextStartup implements ApplicationRunner, ServletContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContextStartup.class);

    private ServletContext servletContext;

    //实现ServletContextAware 可获得上下文 servletContext
    @Override
    public void setServletContext(ServletContext servletContext) {
        LOGGER.info("获得上下文");
        this.servletContext = servletContext;
    }

    //实现ApplicationRunner   可在springboot应用启动后进行初始化操作
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LOGGER.info("sprinboot 启动啦");
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
}