package com.jami.web.controllers;

import com.jami.domain.domains.AuthenticationDomain;
import com.jami.domain.models.Login;
import com.jami.domain.models.Password;
import com.jami.domain.models.User;
import com.jami.utils.Response;
import com.jami.web.commands.RegisterCommand;
import org.json.JSONObject;
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

    @GetMapping(value = "list")
    private Response<String> list(HttpServletResponse response){
        List<JSONObject> collect = authenticationDomain.getUsers()
                .getData()
                .stream()
                .map(this::toWebUser)
                .collect(Collectors.toList());
        return Response.create(collect, OK);
    }

    private JSONObject toWebUser(User user){
        JSONObject object = new JSONObject();
        object.put("login", user.getLogin());
        return object;
    }

}
