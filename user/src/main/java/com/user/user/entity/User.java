package com.user.user.entity;

import java.util.Date;
import java.util.UUID;

public class User {
    private final UUID userId;
    private final String userName;
    private String phoneNumber;
    private String emailAddress;
    private Date latestLocationTimestamp;


    public User(UUID userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
