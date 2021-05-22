package com.fastlane.service.domain.user.ui;

import com.fastlane.service.domain.user.application.UserService;
import com.fastlane.service.domain.user.domain.User;
import com.fastlane.service.domain.user.dto.UserRequest;
import com.fastlane.service.domain.utils.UriUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private static final String USER_CREATE_FORMATTER = "/user/%s";

    private final UserService userService;

    @PostMapping
    public ResponseEntity save(@RequestBody UserRequest request) {
        User user = userService.save(request);
        return ResponseEntity.created(redirectCreateUri(user)).build();
    }

    private URI redirectCreateUri(User user) {
        return UriUtil.redirectUri(USER_CREATE_FORMATTER, user.getId());
    }
}
