package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubService extends BaseEntity<Integer> {
    @Column(unique = true)
    private String subServiceName;
    private double basePrice;
    private String description;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "subServices_expert",
            joinColumns = @JoinColumn(name = "subService_id"),
            inverseJoinColumns = @JoinColumn(name = "expert_id"))
    private Set<Expert> experts;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Service service;

    @Override
    public String toString() {
        return "SubService{" +
                " id = " +getId()+
                ", subServiceName='" + subServiceName + '\'' +
                ", basePrice=" + basePrice +
                ", description='" + description + '\'' +
                "} ";
    }
}
