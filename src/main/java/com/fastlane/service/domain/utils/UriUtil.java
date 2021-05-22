package com.fastlane.service.domain.utils;

import java.net.URI;

public class UriUtil {

    public static <T> URI redirectUri(String formatter, T param) {
        return URI.create(String.format(formatter, param));
    }
}
