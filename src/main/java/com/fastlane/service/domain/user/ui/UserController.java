package com.fastlane.service.domain.user.ui;

import com.fastlane.service.domain.user.application.UserService;
import com.fastlane.service.domain.user.domain.User;
import com.fastlane.service.domain.user.dto.UserRequest;
import com.fastlane.service.domain.user.dto.UserResponse;
import com.fastlane.service.domain.utils.UriUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable String id) {
        User user = userService.find(id);
        return ResponseEntity.ok().body(UserResponse.of(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }

    private URI redirectCreateUri(User user) {
        return UriUtil.redirectUri(USER_CREATE_FORMATTER, user.getId());
    }
}
