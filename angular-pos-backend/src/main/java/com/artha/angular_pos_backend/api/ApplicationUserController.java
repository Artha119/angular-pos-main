package com.artha.angular_pos_backend.api;

import com.artha.angular_pos_backend.dto.requestDto.RequestApplicationUserDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponseApplicationUserDto;
import com.artha.angular_pos_backend.service.ApplicationUserService;
import com.artha.angular_pos_backend.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class ApplicationUserController {
    private final ApplicationUserService applicationUserService;
    @PostMapping
    public ResponseEntity<StandardResponse> register(@RequestBody RequestApplicationUserDto dto){
        applicationUserService.register(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"User Registered",null),
                HttpStatus.CREATED
                );
    }
    @GetMapping
    public ResponseEntity<StandardResponse> login(@RequestParam String email,@RequestParam String password){
        boolean isPresent = applicationUserService.login(email, password);
        return new ResponseEntity<>(
                new StandardResponse(200,"User Logged",isPresent),
                HttpStatus.OK
        );
    }
    @GetMapping("/{email}")
    public ResponseEntity<StandardResponse> getByEmail(@PathVariable String email){
        ResponseApplicationUserDto user = applicationUserService.getByEmail(email);
        return new ResponseEntity<>(
                new StandardResponse(200,"User Data",user),
                HttpStatus.OK
        );
    }
}
