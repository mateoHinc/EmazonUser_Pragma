package com.EmazonPragma.EmazonUser_Pragma.domain.utils;

public enum Roles {
    ADMIN("ADMIN"),
    WAREHOUSE_ASSISTANT("WAREHOUSE_ASSISTANT"),
    CUSTOMER("CUSTOMER");

    private String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
