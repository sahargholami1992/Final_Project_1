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
public class Comment extends BaseEntity<Integer> {
    private int score;
    private String comment;




}
