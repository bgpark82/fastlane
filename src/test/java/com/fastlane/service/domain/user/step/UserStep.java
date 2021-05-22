package com.fastlane.service.domain.user.step;

import com.fastlane.service.domain.user.dto.UserRequest;
import com.fastlane.service.domain.user.dto.UserRequestStub;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class UserStep {

    public static void 사용자_생성_됨(ExtractableResponse<Response> response) {
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    public static ExtractableResponse<Response> 사용자_생성_요청(UserRequest userRequestStub) {
        return RestAssured
                .given().log().all()
                .body(userRequestStub)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/api/v1/users")
                .then().log().all().extract();
    }

    public static UserRequest 사용자_생성_스텁(String id, String password) {
        return UserRequestStub.of(id, password);
    }
}
