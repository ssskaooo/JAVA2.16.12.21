package ru.biriukov.clientserver.commands;

import java.io.Serializable;

public class ErrorCommandData implements Serializable {

    private final String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public ErrorCommandData(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
