package com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.adapter;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.entity.UserEntity;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.mapper.UserEntityMapper;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.persistence.RoleRepository;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.persistence.UserRepository;
import com.EmazonPragma.EmazonUser_Pragma.domain.model.User;
import com.EmazonPragma.EmazonUser_Pragma.domain.spi.UserPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final RoleRepository roleRepository;

    @Override
    public void createUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setRole(
                roleRepository.findByRoleName(userEntity.getRole().getRoleName()).orElse(null));
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
}
