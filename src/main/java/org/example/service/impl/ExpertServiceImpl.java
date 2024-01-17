package org.example.service.impl;

import org.example.entity.Expert;
import org.example.entity.enumaration.ExpertStatus;
import org.example.repository.ExpertRepository;
import org.example.service.ExpertService;
import org.example.service.dto.ExpertRegisterDto;
import org.example.service.user.UserServiceImpl;

import javax.persistence.NoResultException;

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
@Override
public Expert logIn(String email, String password) {

    Expert user = repository.findByEmail(email).
            orElseThrow(() -> new NoResultException("userName or password is wrong"));

    if (password.equals(user.getPassword()) && !user.getExpertStatus().equals(ExpertStatus.AWAITING_CONFIRMATION)) {
        return user;
    }
    throw new RuntimeException("userName or password is wrong or you are new yet");

}

}
