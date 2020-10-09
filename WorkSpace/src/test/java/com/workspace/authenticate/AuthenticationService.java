package com.workspace.authenticate;

public class AuthenticationService {

    public boolean authorizedUser(User stubUser, User testUser) {
        return stubUser.getName().equals(testUser.getName())
                    && stubUser.getDob().equals(testUser.getDob())
                    && stubUser.getCountry().equals(testUser.getCountry());
    }

}
