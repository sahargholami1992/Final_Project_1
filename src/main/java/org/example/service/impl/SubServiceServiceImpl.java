package org.example.service.impl;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.Expert;
import org.example.entity.Service;
import org.example.entity.SubService;
import org.example.repository.SubServiceRepository;
import org.example.service.SubServiceService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SubServiceServiceImpl extends BaseServiceImpl<Integer, SubService, SubServiceRepository>
                                 implements SubServiceService {
    public SubServiceServiceImpl(SubServiceRepository repository) {
        super(repository);
    }

    @Override
    public void deleteByEXPERT(SubService subService, Expert expert) {
        subService.getExperts().remove(expert);
        repository.saveOrUpdate(subService);
    }

    @Override
    public void saveExpert(SubService subService, Expert expert) {
        Set<Expert> experts = new HashSet<>();
        experts.add(expert);
        subService.setExperts(experts);
        repository.saveOrUpdate(subService);
    }

    @Override
    public void editSubService(String subServiceName, double price, String description) {
        repository.updateSubService(subServiceName,price,description);
    }

    @Override
    public Collection<SubService> findByService(Service service) {
        return repository.findByService(service);
    }

    @Override
    public boolean existByName(String subServiceName) {
        return repository.existByName(subServiceName);
    }
}
