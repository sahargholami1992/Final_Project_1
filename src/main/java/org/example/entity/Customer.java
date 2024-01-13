package org.example.entity;

import lombok.*;
import org.example.entity.enumaration.ExpertStatus;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer extends User {
    @OneToOne
    private Credit credit;


}
