package com.example.projspringapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class Supervisor {
    private @Id
    @GeneratedValue Long id;
    private String name;
    @ManyToOne()
    private Paladya paladya;
    private String password;
    private String email;
}
