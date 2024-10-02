package com.EmazonPragma.EmazonUser_Pragma.domain.api.usecase;

import com.EmazonPragma.EmazonUser_Pragma.domain.api.UserServicePort;
import com.EmazonPragma.EmazonUser_Pragma.domain.exceptions.RoleNotFoundException;
import com.EmazonPragma.EmazonUser_Pragma.domain.exceptions.UserDocumentAlreadyExistsException;
import com.EmazonPragma.EmazonUser_Pragma.domain.exceptions.UserEmailAlreadyExistsException;
import com.EmazonPragma.EmazonUser_Pragma.domain.model.User;
import com.EmazonPragma.EmazonUser_Pragma.domain.spi.UserPersistencePort;
import com.EmazonPragma.EmazonUser_Pragma.domain.utils.DomainConstants;
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

        if(!userPersistencePort.existsRolByName(Roles.WAREHOUSE_ASSISTANT.name())) {
            throw new RoleNotFoundException(String.format(DomainConstants.ROLE_NOT_FOUND, Roles.WAREHOUSE_ASSISTANT.name()));
        }
        userPersistencePort.createUser(user);
    }

    @Override
    public void createWarehouseAssistant(User user) {
        createUser(user);
    }
}
