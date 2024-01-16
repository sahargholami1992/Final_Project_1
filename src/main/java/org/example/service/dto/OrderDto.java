package org.example.service.dto;

import lombok.Getter;
import org.example.entity.enumaration.StatusOrder;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
@Getter
public class OrderDto implements Serializable {
    private String address;
    private double recommendedPrice;
    private String description;
    private LocalDate dateDoOrder;
    private StatusOrder statusOrder;

    public OrderDto(String address, double recommendedPrice, String description, LocalDate dateDoOrder) {
        this.address = address;
        this.recommendedPrice = recommendedPrice;
        this.description = description;
        this.dateDoOrder = dateDoOrder;
        this.statusOrder = StatusOrder.WAITING_FOR_EXPERT_SELECTION;
    }
}
