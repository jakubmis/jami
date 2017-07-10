package com.jami.web.commands;

import lombok.Data;
import lombok.NonNull;

/**
 * Created by Mis on 2017-07-10.
 */
@Data
public class RegisterCommand {

    public RegisterCommand() {
    }

    @NonNull
    private String login;
    @NonNull
    private String password;

}
