package com.example.projspringapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequestDTO {
    private String image;
    private String description;
    private Long longitude;
    private Long latitude;
    private Long paladyaId;
    private Long userId;
    private String status;
    private String type;
}
