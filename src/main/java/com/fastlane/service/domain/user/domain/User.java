package com.fastlane.service.domain.user.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class User {

    @Id
    private String id;
    private String password;

    public static User create(String id, String password) {
        User user = new User();
        user.id = id;
        user.password = password;
        return user;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
