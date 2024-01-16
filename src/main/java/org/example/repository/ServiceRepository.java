package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.Service;

import java.util.Optional;

public interface ServiceRepository extends BaseRepository<Integer, Service> {
    boolean existByServiceName(String serviceName);

    Optional<Service> findByServiceName(String serviceName);
}
