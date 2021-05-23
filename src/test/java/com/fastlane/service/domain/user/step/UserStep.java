package com.fastlane.service.domain.user.step;

import com.fastlane.service.domain.user.dto.UserRequest;
import com.fastlane.service.domain.user.dto.UserRequestStub;
import com.fastlane.service.domain.user.dto.UserResponse;
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
}
