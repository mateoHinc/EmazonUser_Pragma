package com.EmazonPragma.EmazonUser_Pragma.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
