package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Service extends BaseEntity<Integer> {
    @Column(unique = true)
    private String serviceName;
    @ToString.Exclude
    @OneToMany(mappedBy = "service")
    private Set<SubService> subServices = new HashSet<>();

    @Override
    public String toString() {
        return "Service{" +
                " id = " +getId()+
                ", serviceName='" + serviceName + '\'' +
                "} " ;
    }
}
