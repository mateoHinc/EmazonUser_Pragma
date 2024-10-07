package com.EmazonPragma.EmazonUser_Pragma.domain.api;

import com.EmazonPragma.EmazonUser_Pragma.domain.model.User;

public interface UserServicePort {
    void createWarehouseAssistant(User user);
    User getUserByEmail(String email);
}
