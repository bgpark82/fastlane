package com.fastlane.service.domain.user.application;

import com.fastlane.service.domain.user.domain.User;
import com.fastlane.service.domain.user.dto.UserRequest;
import com.fastlane.service.domain.user.step.UserStep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사용자 관련 서비스 테스트")
class UserServiceTest {

    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @DisplayName("사용자를 생성한다.")
    @Test
    void save() {
        // given
        UserRequest userRequestStub = UserStep.사용자_생성_스텁("아이디", "비밀번호");

        // when
        User user = userService.save(userRequestStub);

        // then
        assertThat(user.getId()).isEqualTo("아이디");
        assertThat(user.getPassword()).isEqualTo("비밀번호");
    }
}