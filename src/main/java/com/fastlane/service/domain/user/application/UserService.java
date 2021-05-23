package com.fastlane.service.domain.user.application;

import com.fastlane.service.domain.user.domain.User;
import com.fastlane.service.domain.user.domain.UserRepository;
import com.fastlane.service.domain.user.dto.PasswordRequest;
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

    public User find(String id) {
        return userRepository.findById(id).get();
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public User changePassword(String 아이디, PasswordRequest newPassword) {
        return null;
    }
}
