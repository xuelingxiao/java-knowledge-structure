package com.xlx.rest.webflux;

import com.xlx.rest.entity.User;
import com.xlx.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> save(ServerRequest request){
        Mono<User> userMono = request.bodyToMono(User.class);


        Mono<Boolean> booleanMono = userMono.map(userRepository::save);

        return ServerResponse.ok().body(booleanMono,Boolean.class);
     }
}
