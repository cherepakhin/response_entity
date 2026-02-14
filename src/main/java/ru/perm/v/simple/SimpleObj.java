package ru.perm.v.simple;

import java.util.Objects;

public class SimpleObj {
    private String message = "Hello World!";

    public SimpleObj() {

    }

    public SimpleObj(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleObj)) return false;
        SimpleObj simpleObj = (SimpleObj) o;
        return Objects.equals(message, simpleObj.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(message);
    }
}
