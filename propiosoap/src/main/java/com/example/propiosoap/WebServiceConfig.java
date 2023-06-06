package com.example.propiosoap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(servlet, "/api/*");
    }

    @Bean(name = "productos")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema productosSchema){
        DefaultWsdl11Definition wsdl11Definition= new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProductosPort");
        wsdl11Definition.setLocationUri("/api");
        wsdl11Definition.setTargetNamespace("http://www.blas.com/gen");
        wsdl11Definition.setSchema(productosSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema productoSchema(){
        return new SimpleXsdSchema(new ClassPathResource("productos.xsd"));
    }
}
