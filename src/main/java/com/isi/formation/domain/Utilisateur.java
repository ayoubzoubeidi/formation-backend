package com.isi.formation.domain;


import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Utilisateur extends BaseEntity {

    private String login;

    private String password;

    private Role role;

}
