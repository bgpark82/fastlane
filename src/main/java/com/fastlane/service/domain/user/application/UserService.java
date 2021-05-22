package com.fastlane.service.domain.user.application;

import com.fastlane.service.domain.user.domain.User;
import com.fastlane.service.domain.user.domain.UserRepository;
import com.fastlane.service.domain.user.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(UserRequest request) {
        return userRepository.save(request.toEntity());
    }
}
