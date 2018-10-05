package com.xlx.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "com.xlx.mvc", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {EnableWebMvc.class})
})
@Configuration
public class RootConfig {
}
