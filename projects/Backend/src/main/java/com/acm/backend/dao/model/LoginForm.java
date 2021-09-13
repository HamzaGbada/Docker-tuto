package com.acm.backend.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginForm {
    @NotBlank
    @NotNull
    private String username;
    @NotBlank
    @NotNull
    private String password;


}
