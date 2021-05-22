package com.fastlane.service.domain.user.dto;

import org.springframework.test.util.ReflectionTestUtils;

public class UserRequestStub {

    public static UserRequest of(String id, String password) {
        UserRequest userRequest = new UserRequest();
        ReflectionTestUtils.setField(userRequest,"id", id);
        ReflectionTestUtils.setField(userRequest,"password", password);
        return userRequest;
    }
}