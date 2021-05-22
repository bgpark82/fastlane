package com.fastlane.service.domain.user.dto;

import org.springframework.test.util.ReflectionTestUtils;

import static org.springframework.test.util.ReflectionTestUtils.setField;

public class UserRequestStub {

    public static UserRequest of(String id, String password) {
        UserRequest userRequest = new UserRequest();
        setField(userRequest,"id", id);
        setField(userRequest,"password", password);
        return userRequest;
    }
}