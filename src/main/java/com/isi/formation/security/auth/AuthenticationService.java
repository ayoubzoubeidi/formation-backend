package com.isi.formation.security.auth;

import com.isi.formation.web.models.SignupRequestBody;

public interface AuthenticationService {

    void createAccount(SignupRequestBody signupRequestBody);

}
