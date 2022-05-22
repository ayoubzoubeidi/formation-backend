package com.isi.formation.security.auth;

import com.isi.formation.security.jwt.JWTService;
import com.isi.formation.web.models.SignupRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller @RequiredArgsConstructor
public class AuthenticationController {

    private final JWTService jwtService;
    private final AuthenticationService authenticationService;

    @GetMapping("/refresh")
    public void refreshTokenEndpoint(HttpServletRequest request, HttpServletResponse response) throws IOException {
        jwtService.refreshToken(request, response);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignupRequestBody signupRequestBody) {
        authenticationService.createAccount(signupRequestBody);
        return ResponseEntity.noContent().build();
    }

}
