package com.revature.quizzard.entities;

public enum Role {

    ADMIN("Admin"), DEV("Dev"), BASIC_USER("Basic User"),
    PREMIUM_USER("Premium User"), LOCKED("Locked");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public static String valueOf(Role role) {
        return role.name;
    }

    @Override
    public String toString() {
        return name;
    }

}
