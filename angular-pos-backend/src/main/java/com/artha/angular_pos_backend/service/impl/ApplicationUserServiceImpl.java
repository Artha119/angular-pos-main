package com.artha.angular_pos_backend.service.impl;

import com.artha.angular_pos_backend.dto.requestDto.RequestApplicationUserDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponseApplicationUserDto;
import com.artha.angular_pos_backend.entity.ApplicationUser;
import com.artha.angular_pos_backend.repository.ApplicationUserRepo;
import com.artha.angular_pos_backend.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepo applicationUserRepo;
    @Override
    public void register(RequestApplicationUserDto dto) {
        if (dto == null) {
            throw new RuntimeException("Data Not Found!");
        }
        ApplicationUser user = ApplicationUser.builder()
                .propertyId(UUID.randomUUID().toString())
                .fullName(dto.getFullName())
                .isActive(dto.isActive())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        applicationUserRepo.save(user);

    }

    @Override
    public boolean login(String email, String password) {
        if (email.equals(null)||password.equals(null)){
            throw new RuntimeException("Data Not Found!");
        }
        Optional<ApplicationUser> selectedUser = applicationUserRepo.login(email, password);
        if (selectedUser.isEmpty()){

            return false;
        }
        return true;


    }

    @Override
    public ResponseApplicationUserDto getByEmail(String email) {
       if (email.equals(null)){
           throw new RuntimeException("Email Not Found!");
       }
        Optional<ApplicationUser> selectedUser = applicationUserRepo.getByEmail(email);
        if (selectedUser.isEmpty()){
            throw new RuntimeException("User Not Found!");
        }
        return ResponseApplicationUserDto.builder()
                .propertyId(selectedUser.get().getPropertyId())
                .email(selectedUser.get().getEmail())
                .fullName(selectedUser.get().getFullName())
                .isActive(selectedUser.get().isActive())
                .password(selectedUser.get().getPassword())
                .build();
    }
}
