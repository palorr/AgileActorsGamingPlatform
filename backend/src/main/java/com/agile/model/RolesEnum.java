package com.agile.model;

public enum RolesEnum {
    ADMIN("ADMIN"),
    USER("USER");

    private String str;

    RolesEnum(String str) {
        this.str = str;
    }

    public String getValue() {
        return this.str;
    }
}
