package org.example.service.impl;

import org.example.entity.Expert;
import org.example.repository.ExpertRepository;
import org.example.service.ExpertService;
import org.example.service.dto.ExpertRegisterDto;
import org.example.service.user.UserServiceImpl;
import org.example.utill.Validation;

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
       repository.saveOrUpdate(expert);

    }
}
