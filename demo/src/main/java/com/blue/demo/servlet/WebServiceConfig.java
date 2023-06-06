package com.blue.demo.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

public class WebServiceConfig {

    @Bean
   public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
    MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
    messageDispatcherServlet.setApplicationContext(context);
    messageDispatcherServlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }
    
}
