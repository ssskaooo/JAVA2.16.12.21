package ru.biriukov.server.chat.auth;

import java.util.Objects;

public class User {

    private final String login;
    private final String userName;
    private final String password;

    public User(String login, String username, String password) {
        this.login = login;
        this.userName = username;
        this.password = password;
    }

    public User(String login, String password) {
        this(login, password, null);
    }

    public String getLogin() {
        return login;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
