package com.fastlane.service.domain.user.acceptance;

import com.fastlane.service.domain.user.dto.UserRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static com.fastlane.service.domain.user.step.UserStep.*;

@DisplayName("사용자 관련 인수 테스트")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserAcceptanceTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @DisplayName("사용자를 등록한다")
    @Test
    void save() {
        // given
        UserRequest userRequestStub = 사용자_생성_스텁();

        // when
        ExtractableResponse<Response> response = 사용자_생성_요청(userRequestStub);

        // then
        사용자_생성_됨(response);
    }
}
