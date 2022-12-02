package com.castletroymedical.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

import com.castletroymedical.dto.UserDto;
import com.castletroymedical.entity.RoleEntity;
import com.castletroymedical.entity.UserEntity;
import com.castletroymedical.repository.RoleRepository;
import com.castletroymedical.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository; 
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                           RoleRepository roleRepository, 
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository; 
        this.passwordEncoder = passwordEncoder;
    }
 

    public void savePatientUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        String roleName = "ROLE_USER";
        RoleEntity role = roleRepository.findByNameIgnoreCase(roleName);
        if (role == null)
            role = checkRoleExist(roleName);
        user.setRoles(Arrays.asList(role));

        userRepository.save(user);
    }

    private RoleEntity checkRoleExist(String roleName) {
        RoleEntity role = new RoleEntity();
        role.setName(roleName);
        return roleRepository.save(role);
    }
 
    public void saveAdminUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        String roleName = "ROLE_ADMIN";
        RoleEntity role = roleRepository.findByNameIgnoreCase(roleName);
        if (role == null)
            role = checkRoleExist(roleName);
        user.setRoles(Arrays.asList(role));

        userRepository.save(user);

    }
 
    public void updatePatientUser(UserDto userDto) {
        savePatientUser(userDto);

    }
 
    public void updateAdminUser(UserDto userDto) {
        saveAdminUser(userDto);
    }
 
    public UserEntity findByEmail(String email) {
        Optional<UserEntity> user = userRepository.findById(email);
        return (user.isPresent()) ? user.get() : null ;
    }

}
