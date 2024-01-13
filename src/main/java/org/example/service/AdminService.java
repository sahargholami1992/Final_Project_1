package org.example.service;

import org.example.entity.Admin;
import org.example.entity.Expert;
import org.example.entity.Service;
import org.example.entity.SubService;
import org.example.service.user.UserService;

import java.util.Collection;

public interface AdminService extends UserService<Admin> {
    void deleteExpertFromSubService(SubService subService, Expert expert);
    void saveExpertForSubService(SubService subService, Expert expert);
    void registerService(Service service);
    void registerSubService(Service service,SubService subService);
    Collection<Service> showAllService();
    Collection<Expert> showAllExpert();
    void changeExpertStatus(Expert expert);



}
