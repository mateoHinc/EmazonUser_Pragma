package com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.persistence;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.entity.RoleEntity;
import com.EmazonPragma.EmazonUser_Pragma.domain.utils.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {
    Optional<RoleEntity> findByName(Roles name);
}
