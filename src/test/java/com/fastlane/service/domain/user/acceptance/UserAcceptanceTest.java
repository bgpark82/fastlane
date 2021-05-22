package com.fastlane.service.domain.user.acceptance;

import com.fastlane.service.domain.common.AcceptanceTest;
import com.fastlane.service.domain.user.dto.UserRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.fastlane.service.domain.user.step.UserStep.*;

@DisplayName("사용자 관련 인수 테스트")
public class UserAcceptanceTest extends AcceptanceTest {

    String 아이디, 비밀번호;

    @BeforeEach
    void setUp() {
        아이디 = "아이디";
        비밀번호 = "비밀번호";
    }

    @DisplayName("사용자를 등록한다")
    @Test
    void save() {
        // given
        UserRequest userRequestStub = 사용자_요청_스텁(아이디, 비밀번호);

        // when
        ExtractableResponse<Response> response = 사용자_생성_요청(userRequestStub);

        // then
        사용자_생성_됨(response);
    }

    @DisplayName("사용자를 조회한다")
    @Test
    void find() {
        // given
        UserRequest userRequestStub = 사용자_요청_스텁(아이디, 비밀번호);
        사용자_생성_되어_있음(userRequestStub);
        final Long id = 1L;

        // when
        ExtractableResponse<Response> response = RestAssured
                .given().log().all()
                .when().get("/api/v1/users/" + id)
                .then().log().all().extract();

        // then
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
