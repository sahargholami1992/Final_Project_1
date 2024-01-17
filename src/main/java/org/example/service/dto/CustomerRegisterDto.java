package org.example.service.dto;

import lombok.Getter;
import org.example.entity.enumaration.Permission;
import org.example.entity.enumaration.Roll;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
public class CustomerRegisterDto implements Serializable {
    private String firstName;
    private String lastName;

    private String email;

    private String password;
    private LocalDate dateRegister;
    private Roll roll;
    private Permission permission;


    public CustomerRegisterDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateRegister = LocalDate.now();
        this.roll = Roll.CUSTOMER;
        this.permission = Permission.ACCEPTED;
    }
}
