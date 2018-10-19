package com.xlx.rest.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class WebfluxConfiguration {

    @Bean
    public RouterFunction<ServerResponse> saveUser(UserHandler userHandler){
        return RouterFunctions.route(RequestPredicates. POST("/flux/user/save"),userHandler::save);
    }
}
