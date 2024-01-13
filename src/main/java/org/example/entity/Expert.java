package org.example.entity;

import lombok.*;
import org.example.entity.enumaration.ExpertStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Expert extends User {
    @Enumerated(EnumType.STRING)
    private ExpertStatus expertStatus;
    private int score;
    @OneToMany(mappedBy = "expert")
    private List<SubService> subServiceList;
    @Lob
    private byte[] profileImage;
    @OneToOne
    private Credit credit;
    @ManyToMany
    @JoinTable(
            name = "expert_subServices",
            joinColumns = @JoinColumn(name = "expert_id"),
            inverseJoinColumns = @JoinColumn(name = "subService_id"))
    private Set<SubService> subServices = new HashSet<>();



}
