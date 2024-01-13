package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class SubService extends BaseEntity<Integer> {
    private String subServiceName;
    private double basePrice;
    private String description;
    @ManyToMany(mappedBy = "subServices")
    private Set<Expert> experts;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Service service;
}
