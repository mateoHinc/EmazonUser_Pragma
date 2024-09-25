package com.EmazonPragma.EmazonUser_Pragma.domain.model;

import com.EmazonPragma.EmazonUser_Pragma.domain.utils.Roles;
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
    private Roles name;
}
