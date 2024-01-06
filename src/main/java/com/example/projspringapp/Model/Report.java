package com.example.projspringapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class Report {
    private @Id
    @GeneratedValue Long id;
    private String image;
    private String description;
    private long longitude;
    private long latitude;
    @JsonIgnore
    @ManyToOne
    private Paladya city;
    @JsonIgnore
    @ManyToOne()
    private User user;
    private String status;
    private String type;


}
