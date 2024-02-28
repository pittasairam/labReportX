package com.rf.labrex.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthRequest {
    @Size(min = 11,max = 11,message = "Tc kimlik numarası 11 haneli olmak zorunda")
    private String identificationNumber;
    private String password;
}
