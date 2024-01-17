package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Offer extends BaseEntity<Integer> {
    private Duration DurationOfWork;
    private LocalDate SuggestedTimeToStartWork;
    private double RecommendedPrice;
    private LocalDate dateRegisterOffer;
    @ManyToOne
    private Expert expert;

    @ManyToOne
    private Order order;




}
