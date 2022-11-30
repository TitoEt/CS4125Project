package com.castletroymedical.service;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.dto.UserDto;
import com.castletroymedical.entity.UserEntity;

public interface UserService {
    void registerPatientUser(UserDto userDto, PatientDto patientDto);
    void saveAdminUser(UserDto userDto);
    void updatePatientUser(UserDto userDto);
    void updateAdminUser(UserDto userDto);
    UserEntity findByEmail(String email);
    //<ISHA> optional: findAllUsers()
}
