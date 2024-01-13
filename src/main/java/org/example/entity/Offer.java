package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;

import javax.persistence.*;
import java.time.Duration;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Offer extends BaseEntity<Integer> {
//    @Temporal(TemporalType.DATE)
    private Duration DurationOfWork;
    @Temporal(TemporalType.DATE)
    private Date SuggestedTimeToStartWork;
    private double RecommendedPrice;
    @Temporal(TemporalType.DATE)
    private Date dateRegisterOffer;
    @ManyToOne
    private Expert expert;

    @ManyToOne
    private Order order;




}
