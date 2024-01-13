package org.example.service.impl;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.Expert;
import org.example.entity.SubService;
import org.example.repository.SubServiceRepository;
import org.example.service.SubServiceService;

public class SubServiceServiceImpl extends BaseServiceImpl<Integer, SubService, SubServiceRepository>
                                 implements SubServiceService {
    public SubServiceServiceImpl(SubServiceRepository repository) {
        super(repository);
    }

    @Override
    public void deleteByEXPERT(SubService subService, Expert expert) {
        repository.deleteByEXPERT(subService,expert);
    }

    @Override
    public void saveExpert(SubService subService, Expert expert) {
        repository.saveExpert(subService,expert);
    }

    @Override
    public void editSubService(String subServiceName, double price, String description) {
        repository.updateSubService(subServiceName,price,description);
    }
}
