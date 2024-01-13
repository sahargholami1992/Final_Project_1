package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;
import org.example.entity.enumaration.StatusOrder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order extends BaseEntity<Integer> {
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private SubService subService;
    private String address;
    private double RecommendedPrice;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date dateDoOrder;
    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;
    @OneToOne
    private Comment comment;




}
