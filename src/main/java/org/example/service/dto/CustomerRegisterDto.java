package org.example.service.dto;

import lombok.Getter;
import org.example.entity.enumaration.Permission;
import org.example.entity.enumaration.Roll;

import java.io.Serializable;
import java.util.Date;
@Getter
public class CustomerRegisterDto implements Serializable {
    private String firstName;
    private String lastName;

    private String email;

    private String password;
    private Date dateRegister;
    private Roll roll;
    private Permission permission;


    public CustomerRegisterDto(String firstName, String lastName, String email, String password, Date dateRegister) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateRegister = dateRegister;
        this.roll = Roll.CUSTOMER;
        this.permission = Permission.ACCEPTED;
    }
}
