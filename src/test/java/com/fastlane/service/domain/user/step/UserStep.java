package com.fastlane.service.domain.user.step;

import com.fastlane.service.domain.user.dto.*;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStep {

    private static final String USER_BASE_URI = "/api/v1/users/";

    public static ExtractableResponse<Response> 사용자_생성_요청(String id, String password) {
        UserRequest userRequestStub = 사용자_요청_스텁(id, password);
        return RestAssured
                .given().log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(userRequestStub)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post(USER_BASE_URI)
                .then().log().all().extract();
    }

    public static ExtractableResponse<Response> 사용자_조회_요청(String id) {
        return RestAssured
                .given().log().all()
                .when().get(USER_BASE_URI + id)
                .then().log().all().extract();
    }

    public static ExtractableResponse<Response> 사용자_삭제_요청(String id) {
        return RestAssured
                .given().log().all()
                .when().delete(USER_BASE_URI + id)
                .then().log().all().extract();
    }

    public static ExtractableResponse<Response> 비밀번호_수정_요청(String newPassword, String id) {
        PasswordRequest request = 비밀번호_요청_스텁(newPassword);
        return RestAssured
                .given().log().all()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().patch(USER_BASE_URI + id)
                .then().log().all().extract();
    }


    public static void 비밀번호_수정_됨(ExtractableResponse<Response> response, String newPassword) {
        UserResponse userResponse = response.as(UserResponse.class);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(userResponse.getPassword()).isEqualTo(newPassword);
    }

    public static void 사용자_삭제_됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    public static void 사용자_생성_됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    public static void 사용자_조회_요청_됨(ExtractableResponse<Response> response, String id, String password) {
        UserResponse userResponse = response.as(UserResponse.class);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(userResponse.getId()).isEqualTo(id);
        assertThat(userResponse.getPassword()).isEqualTo(password);
    }

    public static ExtractableResponse<Response> 사용자_생성_되어_있음(String id, String password) {
        return 사용자_생성_요청(id, password);
    }

    public static UserRequest 사용자_요청_스텁(String id, String password) {
        return UserRequestStub.of(id, password);
    }

    public static PasswordRequest 비밀번호_요청_스텁(String password) {
        return PasswordRequestStub.of(password);
    }
}
