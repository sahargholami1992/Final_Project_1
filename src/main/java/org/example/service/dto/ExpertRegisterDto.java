package org.example.service.dto;

import lombok.Getter;
import org.example.entity.SubService;
import org.example.entity.enumaration.ExpertStatus;
import org.example.entity.enumaration.Permission;
import org.example.entity.enumaration.Roll;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
public class ExpertRegisterDto implements Serializable {
    private String firstName;
    private String lastName;

    private String email;

    private String password;
    private LocalDate dateRegister;
    private Roll roll;
    private Permission permission;
    private ExpertStatus expertStatus;
    private int score;
    private byte[] profileImage;

    public ExpertRegisterDto(String firstName, String lastName, String email, String password, byte[] profileImage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateRegister = LocalDate.now();
        this.roll = Roll.EXPERT;
        this.permission = Permission.WAITING;
        this.expertStatus = ExpertStatus.NEW;
        this.score = 0;
        this.profileImage = profileImage;
    }
}

