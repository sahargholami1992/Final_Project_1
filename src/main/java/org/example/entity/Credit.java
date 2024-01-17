package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;
import javax.persistence.Entity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Credit extends BaseEntity<Integer> {
    private double balance;




}
