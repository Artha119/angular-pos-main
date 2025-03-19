package com.artha.angular_pos_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "application_user")
public class ApplicationUser {

    @Id
    private String propertyId;
    @Column(name = "email",unique = true,nullable = false,length = 225)
    private String email;
    @Column(name = "password",nullable = false,length = 225)
    private String password;
    @Column(name = "full_name",nullable = false,length = 225)
    private String fullName;
    @Column(name = "is_active",nullable = false,columnDefinition = "TINYINT")
    private boolean isActive;

}
