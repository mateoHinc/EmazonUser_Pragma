package com.EmazonPragma.EmazonUser_Pragma.domain.spi;

import com.EmazonPragma.EmazonUser_Pragma.domain.model.User;

public interface UserPersistencePort {
    void createUser(User user);
    boolean userExistsByNumberDocument(String numberDocument);
    boolean userExistsByEmail(String email);
}
