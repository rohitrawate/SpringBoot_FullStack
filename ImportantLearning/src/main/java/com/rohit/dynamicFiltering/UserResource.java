package com.rohit.dynamicFiltering;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @GetMapping("/users/public")
    @JsonView(UserViews.Public.class)
    public User getPublicUser() {
        return new User(1, "Rohit", "rohit@gmail.com", "ADMIN");
    }

    @GetMapping("/users/internal")
    @JsonView(UserViews.Internal.class)
    public User getInternalUser() {
        return new User(1, "Rohit", "rohit@gmail.com", "ADMIN");
    }
}
