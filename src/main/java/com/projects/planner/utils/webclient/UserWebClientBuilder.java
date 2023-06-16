package com.projects.planner.utils.webclient;

import com.projects.planner.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class UserWebClientBuilder {

    private static final String baseUrlToUser = "http://localhost:8765/planner-users/user/";
    private static final String baseUrlToData = "http://localhost:8765/planner-todo/data/";

    public boolean userExists(Long userId) {
        try {
            User user = WebClient.create(baseUrlToUser)
                    .post()
                    .uri("id")
                    .bodyValue(userId)
                    .retrieve()
                    .bodyToFlux(User.class)
                    .blockFirst();

            if (user != null) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Mono<Boolean> setDefaultUserData(Long userId) {

        return WebClient.create(baseUrlToData)
                .post()
                .uri("init")
                .bodyValue(userId)
                .retrieve()
                .bodyToMono(Boolean.class);

    }
}
