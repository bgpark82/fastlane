package com.fastlane.service.domain.user.dto;

import static org.springframework.test.util.ReflectionTestUtils.setField;

public class PasswordRequestStub {

    public static PasswordRequest of(String password) {
        PasswordRequest request = new PasswordRequest();
        setField(request,"password", password);
        return request;
    }
}
