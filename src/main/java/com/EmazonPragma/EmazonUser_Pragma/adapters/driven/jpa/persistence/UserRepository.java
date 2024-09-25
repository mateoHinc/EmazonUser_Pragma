package com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.persistence;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByNumberDocument(String numberDocument);
    boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}
