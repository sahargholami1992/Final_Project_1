package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Service extends BaseEntity<Integer> {
    private String serviceName;
    @OneToMany(mappedBy = "service")
    private Set<SubService> subServices = new HashSet<>();
}
