package com.fastlane.service.domain.user.dto;

import static org.springframework.test.util.ReflectionTestUtils.setField;

public class UserRequestStub {

    private static final String ID = "id";
    private static final String PASSWORD = "password";

    public static UserRequest of(String id, String password) {
        UserRequest userRequest = new UserRequest();
        setField(userRequest, ID, id);
        setField(userRequest,PASSWORD, password);
        return userRequest;
    }
}