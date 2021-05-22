package com.fastlane.service.domain.user.acceptance;

import com.fastlane.service.domain.user.dto.UserRequest;
import com.fastlane.service.domain.user.dto.UserRequestStub;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

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
        UserRequest userRequestStub = UserRequestStub.of("아이디", "비밀번호");

        // when
        ExtractableResponse<Response> response = RestAssured
                .given().log().all()
                .body(userRequestStub)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/api/v1/users")
                .then().log().all().extract();

        // then
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
