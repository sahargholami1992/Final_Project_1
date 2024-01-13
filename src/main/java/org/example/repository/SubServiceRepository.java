package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.Expert;
import org.example.entity.SubService;

public interface SubServiceRepository extends BaseRepository<Integer, SubService> {
    void deleteByEXPERT(SubService subService, Expert expert);

    void saveExpert(SubService subService, Expert expert);

    void updateSubService(String subServiceName, double price, String description);
}
