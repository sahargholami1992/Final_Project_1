package org.example.service.impl;

import org.example.entity.Expert;
import org.example.entity.SubService;
import org.example.repository.ExpertRepository;
import org.example.service.ExpertService;
import org.example.service.dto.ExpertRegisterDto;
import org.example.service.user.UserServiceImpl;

public class ExpertServiceImpl extends UserServiceImpl<Expert, ExpertRepository>
                              implements ExpertService {
    public ExpertServiceImpl(ExpertRepository repository) {
        super(repository);
    }

    @Override
    public void registerExpert(ExpertRegisterDto dto) {
        Expert expert = new Expert();
       expert.setFirstName(dto.getFirstName());
       expert.setLastName(dto.getLastName());
       expert.setEmail(dto.getEmail());
       expert.setPassword(dto.getPassword());
       expert.setDateRegister(dto.getDateRegister());
       expert.setRoll(dto.getRoll());
       expert.setPermission(dto.getPermission());
       expert.setExpertStatus(dto.getExpertStatus());
       expert.setScore(dto.getScore());
       expert.setProfileImage(dto.getProfileImage());
       repository.saveOrUpdate(expert);

    }

    @Override
    public void changeExpertStatus(Expert expert) {
        repository.updateExpert(expert);
    }
//    @Override
//    public void saveExpert(SubService subService, Expert expert) {
//        repository.saveExpert(subService,expert);
//    }

}
