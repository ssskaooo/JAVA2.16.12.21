package ru.biriukov.clientserver.commands;

import java.io.Serializable;

public class AuthOkCommandData implements Serializable {

    private String username;


    public AuthOkCommandData(String userName) {
        this.username = userName;
    }

    public String getUsername() {
        return username;
    }


}
