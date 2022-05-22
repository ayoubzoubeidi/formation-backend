package com.isi.formation.security.auth;

import com.isi.formation.domain.ApplicationUser;
import com.isi.formation.domain.Role;
import com.isi.formation.repository.RoleRepository;
import com.isi.formation.repository.UserRepository;
import com.isi.formation.web.models.SignupRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createAccount(SignupRequestBody signupRequestBody) {

        String username = signupRequestBody.getUsername();

        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username Already Exists");
        }

        String password = passwordEncoder.encode(signupRequestBody.getPassword());

        Role admin = roleRepository.findByName("admin");

        userRepository.saveAndFlush(
                ApplicationUser.builder().username(username).password(password).role(admin).build()
        );

    }
}
