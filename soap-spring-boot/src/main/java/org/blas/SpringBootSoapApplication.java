package org.blas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass=true)

@SpringBootApplication
public class SpringBootSoapApplication {
    public static void main(String[] args) {     SpringApplication.run(SpringBootSoapApplication.class,args);}
}
