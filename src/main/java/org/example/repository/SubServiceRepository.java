package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.Service;
import org.example.entity.SubService;
import java.util.Collection;

public interface SubServiceRepository extends BaseRepository<Integer, SubService> {

    void updateSubService(String subServiceName, double price, String description);

    Collection<SubService> findByService(Service service);

    boolean existByName(String subServiceName);

}
