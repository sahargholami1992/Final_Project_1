package org.example.repository;


import org.example.entity.Expert;
import org.example.entity.SubService;
import org.example.repository.user.UserRepository;

public interface ExpertRepository extends UserRepository<Expert> {
    void updateExpert(Expert expert);
//    void saveExpert(SubService subService, Expert expert);
}
