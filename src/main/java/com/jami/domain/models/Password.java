package com.jami.domain.models;

import lombok.Getter;

import java.util.Objects;

/**
 * Created by Mis on 2017-07-10.
 */
@Getter
public class Password {

    private String value;

    public Password(String value) {
        Objects.requireNonNull(value, "password must be not null");
        this.value = value;
    }

    public boolean isValid() {
        return value.length() > 5 && value.matches(".*\\d+.*");
    }
}
