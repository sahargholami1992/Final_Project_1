package org.example.entity;

import lombok.*;
import javax.persistence.*;


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
