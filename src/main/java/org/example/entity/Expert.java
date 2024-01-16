package org.example.entity;

import lombok.*;
import org.example.entity.enumaration.ExpertStatus;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expert extends User {
    @Enumerated(EnumType.STRING)
    private ExpertStatus expertStatus;
    private int score;
    @Lob
    private byte[] profileImage;
    @OneToOne
    private Credit credit;
    @ToString.Exclude
    @ManyToMany(mappedBy = "experts")
    private Set<SubService> subServices = new HashSet<>();

    @Override
    public String toString() {
        return "Expert{" +
                super.toString()+
                ", expertStatus=" + expertStatus +
                ", score=" + score +
                "} " ;
    }
}
