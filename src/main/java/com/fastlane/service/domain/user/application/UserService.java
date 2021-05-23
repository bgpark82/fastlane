package com.fastlane.service.domain.user.application;

import com.fastlane.service.domain.user.domain.User;
import com.fastlane.service.domain.user.domain.UserRepository;
import com.fastlane.service.domain.user.dto.PasswordRequest;
import com.fastlane.service.domain.user.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public User save(UserRequest request) {
        return userRepository.save(request.toEntity());
    }

    @Transactional(readOnly = true)
    public User find(String id) {
        return findUserById(id);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public User changePassword(String id, PasswordRequest request) {
        User user = findUserById(id);
        user.changePassword(request.getPassword());
        return user;
    }

    private User findUserById(String id) {
        return userRepository.findById(id).get();
    }
}
