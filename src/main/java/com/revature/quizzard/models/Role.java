package com.revature.quizzard.models;

public enum Role {

    ADMIN("Admin"), DEV("Dev"), BASIC_USER("Basic User"),
    PREMIUM_USER("Premium User"), LOCKED("Locked");

    private String name;

    Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
