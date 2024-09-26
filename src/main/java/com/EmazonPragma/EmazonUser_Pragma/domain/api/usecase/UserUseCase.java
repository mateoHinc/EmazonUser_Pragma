package com.EmazonPragma.EmazonUser_Pragma.domain.api.usecase;

import com.EmazonPragma.EmazonUser_Pragma.domain.api.UserServicePort;
import com.EmazonPragma.EmazonUser_Pragma.domain.exceptions.UserDocumentAlreadyExistsException;
import com.EmazonPragma.EmazonUser_Pragma.domain.exceptions.UserEmailAlreadyExistsException;
import com.EmazonPragma.EmazonUser_Pragma.domain.model.Role;
import com.EmazonPragma.EmazonUser_Pragma.domain.model.User;
import com.EmazonPragma.EmazonUser_Pragma.domain.spi.UserPersistencePort;
import com.EmazonPragma.EmazonUser_Pragma.domain.utils.Roles;

import static com.EmazonPragma.EmazonUser_Pragma.domain.utils.ValidationUtils.validateBirthDate;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    private void createUser(User user) {
        validateBirthDate(user.getBirthDate());

        if(userPersistencePort.userExistsByEmail(user.getEmail())) {
            throw new UserEmailAlreadyExistsException(user.getEmail());
        }

        if(userPersistencePort.userExistsByNumberDocument(user.getNumberDocument())) {
            throw new UserDocumentAlreadyExistsException(user.getNumberDocument());
        }
    }

    @Override
    public void createWarehouseAssistant(User user) {
        user.setRole(new Role(null, Roles.WAREHOUSE_ASSISTANT));
        createUser(user);
    }
}
