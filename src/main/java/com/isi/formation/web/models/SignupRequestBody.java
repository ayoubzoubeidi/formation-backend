package com.isi.formation.web.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupRequestBody {

    private String username;
    private String password;

}
