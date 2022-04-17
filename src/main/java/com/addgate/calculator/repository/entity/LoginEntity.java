package com.addgate.calculator.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LoginEntity {

        @Id
        private Long id;

        @Column
        private String email;

        @Column
        private String password;

}
