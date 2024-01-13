package org.example.service.impl;

import org.example.entity.Admin;
import org.example.entity.Expert;
import org.example.entity.Service;
import org.example.entity.SubService;
import org.example.repository.AdminRepository;
import org.example.service.AdminService;
import org.example.service.SubServiceService;
import org.example.service.user.UserServiceImpl;

public class AdminServiceImpl extends UserServiceImpl<Admin, AdminRepository>
                              implements AdminService {
    protected final SubServiceService service;
    public AdminServiceImpl(AdminRepository repository,SubServiceService service) {
        super(repository);
        this.service=service;
    }

    @Override
    public void deleteExpertFromSubService(SubService subService, Expert expert) {
        service.deleteByEXPERT(subService,expert);
    }

    @Override
    public void saveExpertForSubService(SubService subService, Expert expert) {
        service.saveExpert(subService,expert);
    }

    @Override
    public void registerService(Service service) {

    }
}
