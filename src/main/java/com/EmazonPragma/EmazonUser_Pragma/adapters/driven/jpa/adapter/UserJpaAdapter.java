package com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.adapter;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.entity.RoleEntity;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.entity.UserEntity;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.mapper.UserEntityMapper;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.persistence.RoleRepository;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.persistence.UserRepository;
import com.EmazonPragma.EmazonUser_Pragma.domain.exceptions.RoleNotFoundException;
import com.EmazonPragma.EmazonUser_Pragma.domain.model.User;
import com.EmazonPragma.EmazonUser_Pragma.domain.spi.UserPersistencePort;
import com.EmazonPragma.EmazonUser_Pragma.domain.utils.DomainConstants;
import com.EmazonPragma.EmazonUser_Pragma.domain.utils.Roles;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final RoleRepository roleRepository;

    @Override
    public void createUser(User user) {

        RoleEntity roleEntity = roleRepository.findByName(Roles.WAREHOUSE_ASSISTANT.getName())
                .orElseThrow(() -> new RoleNotFoundException(
                        String.format(DomainConstants.ROLE_NOT_FOUND, Roles.WAREHOUSE_ASSISTANT)
                ));
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setRole(roleEntity);
        userRepository.save(userEntity);
    }

    @Override
    public boolean userExistsByNumberDocument(String numberDocument) {
        return userRepository.existsByNumberDocument(numberDocument);
    }

    @Override
    public boolean userExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsRolByName(String role) {
        return roleRepository.findByName(role).isPresent();
    }

    @Override
    public User getUserByEmail(String email) {
        return userEntityMapper.toUser(userRepository.findByEmail(email).orElseThrow());
    }
}
