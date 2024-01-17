package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;
import org.example.entity.enumaration.Permission;
import org.example.entity.enumaration.Roll;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity<Integer> {
    private String firstName;
    private String lastName;
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank
    private String password;
    private LocalDate dateRegister;
    @Enumerated(EnumType.STRING)
    private Roll roll;
    @Enumerated(EnumType.STRING)
    private Permission permission;

    @Override
    public String toString() {
        return " id = " +getId()+
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateRegister=" + dateRegister +
                ", roll=" + roll +
                ", permission=" + permission ;
    }
}
