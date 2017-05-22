package com.jami.dto;

import java.util.Date;

/**
 * Created by jakub.mis on 5/22/2017.
 */
@Data
public class User {

    private Integer id;
    private String login;
    private String password;
    private Date creationDate;
}
