package org.example.service.impl;

import org.example.entity.Admin;
import org.example.entity.Expert;
import org.example.entity.Service;
import org.example.entity.SubService;
import org.example.entity.enumaration.ExpertStatus;
import org.example.repository.AdminRepository;
import org.example.service.AdminService;
import org.example.service.ExpertService;
import org.example.service.ServiceService;
import org.example.service.SubServiceService;
import org.example.service.user.UserServiceImpl;

import java.util.Collection;

public class AdminServiceImpl extends UserServiceImpl<Admin, AdminRepository>
                              implements AdminService {
    protected final SubServiceService subServiceService;
    protected final ServiceService serviceService;
    protected final ExpertService expertService;
    public AdminServiceImpl(AdminRepository repository,SubServiceService subServiceService,ServiceService serviceService,ExpertService expertService) {
        super(repository);
        this.subServiceService  =subServiceService;
        this.serviceService=serviceService;
        this.expertService=expertService;
    }

    @Override
    public void saveService(String serviceName) {
        if (!serviceService.existByServiceName(serviceName.toLowerCase())){
            Service service = new Service();
            service.setServiceName(serviceName.toLowerCase());
            serviceService.saveOrUpdate(service);
        }else throw new IllegalArgumentException(" this service existed ");
    }

    @Override
    public void saveSubService(String serviceName, SubService subService) {
        if (serviceService.existByServiceName(serviceName) && !subServiceService.existByName(subService.getSubServiceName())){
            Service service = serviceService.findByServiceName(serviceName);
            subService.setService(service);
            subServiceService.saveOrUpdate(subService);
        }else throw new  IllegalArgumentException(" this service not exist or duplicate subService name ");
}

    @Override
    public void deleteExpertFromSubService(SubService subService, Expert expert) {
        subServiceService.deleteByEXPERT(subService,expert);
    }

    @Override
    public void saveExpertForSubService(SubService subService, Expert expert) {
        if (subService != null && expert != null && expert.getExpertStatus().equals(ExpertStatus.ACCEPTED) ) {
            subServiceService.saveExpert(subService, expert);
        }else throw new NullPointerException(" Expert or SubService not found in the database or ExpertStatus is not equals ACCEPTED  ");

    }

    @Override
    public void registerService(Service service) {
        serviceService.saveOrUpdate(service);
    }

    @Override
    public Collection<SubService> ShowAllSubService() {
        return subServiceService.loadAll();

    }

    @Override
    public Collection<Service> showAllService() {
        return serviceService.loadAll();
    }

    @Override
    public Collection<Expert> showAllExpert() {
        return expertService.loadAll();
    }

    @Override
    public void changeExpertStatus(Expert expert) {
        expertService.changeExpertStatus(expert);
    }

    @Override
    public boolean existByServiceName(String serviceName) {
        return serviceService.existByServiceName(serviceName);
    }
}
