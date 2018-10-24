package com.xlx.mvc.jmx;

import com.xlx.mvc.web.controller.HomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;
import org.springframework.jmx.support.RegistrationPolicy;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JMXConfig {

    @Bean
    public MBeanExporter mBeanExporter(HomeController homeController,MethodNameBasedMBeanInfoAssembler assembler){
        MBeanExporter mBeanExporter = new MBeanExporter();
        Map<String,Object> beans = new HashMap<String, Object>();
        beans.put("mvc:name=HomeController",homeController);
        mBeanExporter.setBeans(beans);
        mBeanExporter.setAssembler(assembler);
        mBeanExporter.setRegistrationPolicy(RegistrationPolicy.FAIL_ON_EXISTING);
        return  mBeanExporter;
    }

    @Bean
    public MethodNameBasedMBeanInfoAssembler assembler(){
        MethodNameBasedMBeanInfoAssembler assembler = new MethodNameBasedMBeanInfoAssembler();
        assembler.setManagedMethods("hello","npe1");
        return assembler;
    }
}
