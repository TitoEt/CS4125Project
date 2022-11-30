package com.castletroymedical.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.dto.UserDto;
import com.castletroymedical.entity.RoleEntity;
import com.castletroymedical.entity.UserEntity; 
import com.castletroymedical.repository.RoleRepository;
import com.castletroymedical.repository.UserRepository;
import com.castletroymedical.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PatientServiceImpl patientService;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PatientServiceImpl patientService,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.patientService = patientService;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerPatientUser(UserDto userDto, PatientDto patientDto){
        savePatientUser(userDto);
        patientService.savePatient(patientDto);
        
    }

    private void savePatientUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        String roleName = "ROLE_PATIENT";
        RoleEntity role = roleRepository.findByNameIgnoreCase(roleName);
        if(role == null) role = checkRoleExist(roleName); 
        user.setRoles(Arrays.asList(role));

        userRepository.save(user);
    }

    private RoleEntity checkRoleExist(String roleName) {
        RoleEntity role = new RoleEntity();
        role.setName(roleName);
        return roleRepository.save(role);
    }

    @Override
    public void saveAdminUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        String roleName = "ROLE_ADMIN";
        RoleEntity role = roleRepository.findByNameIgnoreCase(roleName);
        if(role == null) role = checkRoleExist(roleName); 
        user.setRoles(Arrays.asList(role));

        userRepository.save(user);
        
    }

    @Override
    public void updatePatientUser(UserDto userDto) {
        savePatientUser(userDto);
        
    }

    @Override
    public void updateAdminUser(UserDto userDto) {
        saveAdminUser(userDto);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
}
