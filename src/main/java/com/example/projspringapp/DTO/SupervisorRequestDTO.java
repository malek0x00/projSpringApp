package com.example.projspringapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorRequestDTO {
    private String name;
    private Long paladyaId;
    private String password;
    private String email;
}
