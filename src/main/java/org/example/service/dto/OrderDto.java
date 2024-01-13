package org.example.service.dto;

import org.example.entity.enumaration.StatusOrder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class OrderDto implements Serializable {
    private String address;
    private double RecommendedPrice;
    private String description;
    private Date dateDoOrder;
    private StatusOrder statusOrder;

    public OrderDto(String address, double recommendedPrice, String description, Date dateDoOrder) {
        this.address = address;
        RecommendedPrice = recommendedPrice;
        this.description = description;
        this.dateDoOrder = dateDoOrder;
        this.statusOrder = StatusOrder.WAITING_FOR_EXPERT_SELECTION;
    }
}
