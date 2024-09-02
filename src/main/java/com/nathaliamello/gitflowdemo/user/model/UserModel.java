package com.nathaliamello.gitflowdemo.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 150)
    private String email;

    @NotNull
    @Past
    @Column(name = "date_of_birth")
    private LocalDate birthDate;

    @NotNull
    @Size(max = 11)
    private String cpf;

    public UserModel() {
    }
}
