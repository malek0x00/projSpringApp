package com.example.projspringapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class User {
    private @Id
    @GeneratedValue Long id;
    private String name;
    @Column(unique=true)
    private String email;
    private String password;
    @Column(unique=true)
    private String cin;
    private String city;
}
