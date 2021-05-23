package com.fastlane.service.domain.user.application;

import com.fastlane.service.domain.user.domain.User;
import com.fastlane.service.domain.user.domain.UserRepository;
import com.fastlane.service.domain.user.dto.UserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.fastlane.service.domain.user.step.UserStep.사용자_요청_스텁;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("사용자 관련 서비스 테스트")
class UserServiceTest {

    UserService userService;
    UserRepository userRepository;

    String 아이디, 비밀번호;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);

        아이디 = "아이디";
        비밀번호 = "비밀번호";
    }

    @DisplayName("사용자를 생성한다")
    @Test
    void save() {
        // given
        UserRequest userRequestStub = 사용자_요청_스텁(아이디, 비밀번호);
        User savedUser = User.create(아이디, 비밀번호);
        when(userRepository.save(any())).thenReturn(savedUser);

        // when
        User user = userService.save(userRequestStub);

        // then
        assertThat(user.getId()).isEqualTo(아이디);
        assertThat(user.getPassword()).isEqualTo(비밀번호);
    }

    @DisplayName("사용자를 조회한다")
    @Test
    void find() {
        // given
        User findUser = User.create(아이디, 비밀번호);
        when(userRepository.findById(any())).thenReturn(Optional.of(findUser));

        // when
        User user = userService.find(아이디);

        // then
        assertThat(user.getId()).isEqualTo(아이디);
        assertThat(user.getPassword()).isEqualTo(비밀번호);
    }
}