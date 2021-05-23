package com.fastlane.service.domain.user.dto;

import com.fastlane.service.domain.user.domain.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private String id;
    private String password;

    public static UserResponse of(User user) {
        UserResponse response = new UserResponse();
        response.id = user.getId();
        response.password = user.getPassword();
        return response;
    }
}
