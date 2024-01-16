package org.example.service;

import org.example.entity.Expert;
import org.example.entity.SubService;
import org.example.service.dto.ExpertRegisterDto;
import org.example.service.user.UserService;

public interface ExpertService extends UserService<Expert> {
    void registerExpert(ExpertRegisterDto dto);

    void changeExpertStatus(Expert expert);
//    void saveExpert(SubService subService, Expert expert);
}
