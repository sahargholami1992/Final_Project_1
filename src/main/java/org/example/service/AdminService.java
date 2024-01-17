package org.example.service;

import org.example.entity.Admin;
import org.example.entity.Expert;
import org.example.entity.Service;
import org.example.entity.SubService;
import org.example.service.user.UserService;

import java.util.Collection;

public interface AdminService extends UserService<Admin> {
    void saveService(String serviceName);
    void saveSubService(String serviceName,SubService subService);
    void deleteExpertFromSubService(SubService subService, Expert expert);
    void saveExpertForSubService(SubService subService, Expert expert);
    void registerService(Service service);
    Collection<SubService> ShowAllSubService();
    Collection<Service> showAllService();
    Collection<Expert> showAllExpert();
    void changeExpertStatus(Expert expert);
    boolean existByServiceName(String serviceName);
    void editSubService(String subServiceName, double price, String description);
}
