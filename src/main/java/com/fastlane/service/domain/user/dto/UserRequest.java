package com.fastlane.service.domain.user.dto;

import com.fastlane.service.domain.user.domain.User;
import lombok.Getter;

@Getter
public class UserRequest {

    private String id;
    private String password;

    public User toEntity() {
        return User.create(this.getId(), this.getPassword());
    }
}
