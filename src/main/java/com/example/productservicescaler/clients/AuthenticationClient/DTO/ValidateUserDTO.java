package com.example.productservicescaler.clients.AuthenticationClient.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateUserDTO {
    private Long userId;
    private String token;
}
