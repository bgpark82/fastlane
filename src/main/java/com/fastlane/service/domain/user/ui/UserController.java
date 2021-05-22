package com.fastlane.service.domain.user.ui;

import com.fastlane.service.domain.user.dto.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @PostMapping
    public ResponseEntity save(@RequestBody UserRequest request) {
        return ResponseEntity.created(URI.create("/user/1")).build();
    }
}
