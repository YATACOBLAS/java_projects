package com.configuration;

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
public class Config extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
    {
        //que es una clase de Spring Web Services que actúa como controlador frontal
        // //para solicitudes entrantes de servicios web
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        //le permite acceder al contenedor de SPRIng para la inyeccion de dependencias
        //para que Spring-WS encuentre otros beans.
        servlet.setApplicationContext(applicationContext);
        //habilitar la transformación de ubicaciones WSDL en mensajes SOAP
        // para que coincidan con la URL donde se implementa el servicio web.
        servlet.setTransformWsdlLocations(true);
        //un objeto que registra el servlet en el contenedor de servlets de la aplicación
        // y especifica la URL donde estará disponible el servlet ("/service/*")
        return new ServletRegistrationBean(servlet, "/service/*");

    }


    //que se utiliza para exponer un servicio web como un archivo WSDL.//
    @Bean(name = "studentDetailsWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema)
    {//objeto que contiene la definición XML del esquema para el servicio web.
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("StudentDetailsPort");
        wsdl11Definition.setLocationUri("/service/student-details");
        wsdl11Definition.setTargetNamespace("http://www.howtodoinjava.com/xml/school");
        wsdl11Definition.setSchema(countriesSchema);
        //Esta instancia se utiliza para exponer el servicio web como un archivo WSDL.
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema countriesSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("student.xsd"));
    }
}
