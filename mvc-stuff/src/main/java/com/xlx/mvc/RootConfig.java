package com.xlx.mvc;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "com.xlx.mvc", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {EnableWebMvc.class})
})
@Configuration
@ImportResource(locations = {"classpath:demo.xml"})
public class RootConfig {
}
