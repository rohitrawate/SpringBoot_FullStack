package com.rohit.dynamicFiltering;

import com.fasterxml.jackson.annotation.JsonView;

public class User {

    @JsonView(UserViews.Public.class)
    private Integer id;

    @JsonView(UserViews.Public.class)
    private String name;

    @JsonView(UserViews.Internal.class)
    private String email;

    @JsonView(UserViews.Internal.class)
    private String role;

    // constructor
    public User(Integer id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // getters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}


