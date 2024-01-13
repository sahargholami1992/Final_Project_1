package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Credit extends BaseEntity<Integer> {
    private double balance;




}
