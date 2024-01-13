package org.example.service;

import org.example.base.service.BaseService;
import org.example.entity.Expert;
import org.example.entity.SubService;

public interface SubServiceService extends BaseService<Integer, SubService> {
    void deleteByEXPERT(SubService subService, Expert expert);

    void saveExpert(SubService subService, Expert expert);
    void editSubService(String subServiceName,double price,String description);
}
