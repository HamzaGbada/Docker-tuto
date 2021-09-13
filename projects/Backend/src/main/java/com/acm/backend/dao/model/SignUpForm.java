package com.acm.backend.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {
    private String name;
    private String username;
    private String email;
    private String password;
    private Long key;
}
