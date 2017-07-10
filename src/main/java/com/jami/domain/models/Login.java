package com.jami.domain.models;

import lombok.Getter;

import java.util.Objects;

/**
 * Created by Mis on 2017-07-10.
 */
@Getter
public class Login {

    private String value;

    public Login(String value) {
        Objects.requireNonNull(value, "login must be not null");
        this.value = value;
    }

    public boolean isValid() {
        return value.length() > 5 && value.matches(".*\\d+.*");
    }

}
