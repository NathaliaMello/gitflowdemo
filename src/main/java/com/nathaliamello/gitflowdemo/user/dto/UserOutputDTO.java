package com.nathaliamello.gitflowdemo.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserOutputDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;

    public UserOutputDTO() {
    }
}
