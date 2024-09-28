package com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.entity;

import com.EmazonPragma.EmazonUser_Pragma.domain.utils.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RoleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles roleName;
}
