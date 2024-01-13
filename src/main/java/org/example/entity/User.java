package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;
import org.example.entity.enumaration.Permission;
import org.example.entity.enumaration.Roll;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity<Integer> {
    private String firstName;
    private String lastName;
    @NotBlank
    private String email;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$",
            message = "Password must contain both letters and numbers"
    )
    private String password;
    private Date dateRegister;
    @Enumerated(EnumType.STRING)
    private Roll roll;
//    @Enumerated(EnumType.STRING)
//    private Permission permission;



}
