package com.fastlane.service.domain.user.acceptance;

import com.fastlane.service.domain.common.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        // when
        ExtractableResponse<Response> response = 사용자_생성_요청(아이디, 비밀번호);

        // then
        사용자_생성_됨(response);
    }

    @DisplayName("사용자를 조회한다")
    @Test
    void find() {
        // given
        사용자_생성_되어_있음(아이디, 비밀번호);

        // when
        ExtractableResponse<Response> response = 사용자_조회_요청(아이디);

        // then
        사용자_조회_요청_됨(response, 아이디, 비밀번호);
    }
}
