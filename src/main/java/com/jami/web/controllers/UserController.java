package com.jami.web.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jami.domain.domains.AuthenticationDomain;
import com.jami.domain.models.Login;
import com.jami.domain.models.Password;
import com.jami.domain.models.User;
import com.jami.utils.Response;
import com.jami.web.commands.RegisterCommand;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

import static com.jami.utils.Response.OK;

/**
 * Created by Mis on 2017-07-10.
 */
@RestController
@RequestMapping(value = "/app/user/")
public class UserController {

    private AuthenticationDomain authenticationDomain;

    public UserController(AuthenticationDomain authenticationDomain) {
        this.authenticationDomain = authenticationDomain;
    }

    @PostMapping(value = "register")
    private Response register(RegisterCommand registerCommand){
        User user = User.builder()
                .login(new Login(registerCommand.getLogin()))
                .password(new Password(registerCommand.getPassword()))
                .build();
        return authenticationDomain.registerUser(user);
    }

    @GetMapping(value = "show")
    private Response<String> show(HttpServletResponse response){
        List<String> collect = authenticationDomain.getUsers()
                .getData()
                .stream()
                .map(User::getLogin)
                .map(Login::getValue)
                .collect(Collectors.toList());
        return Response.create(collect, OK);
    }

}
