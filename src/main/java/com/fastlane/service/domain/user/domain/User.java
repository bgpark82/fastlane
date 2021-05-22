package com.fastlane.service.domain.user.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class User {

    @Id
    private String id;
    private String password;

}
