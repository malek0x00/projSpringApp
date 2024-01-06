package com.example.projspringapp.RestController;

import com.example.projspringapp.DTO.SupervisorRequestDTO;
import com.example.projspringapp.Model.Supervisor;
import com.example.projspringapp.Respository.PaladyaRepository;
import com.example.projspringapp.Respository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupervisorController {
    @Autowired
    SupervisorRepository supervisorRepository;
    @Autowired
    PaladyaRepository paladyaRepository;

    @GetMapping("/supervisors/{id}")
    public List<Supervisor> getSupervisors(@PathVariable Long id){
        return supervisorRepository.findAllByPaladyaId(id);
    }

    @PostMapping("/supervisor")
    public Supervisor addSupervisor(@RequestBody SupervisorRequestDTO supervisor){
        Supervisor sp = Supervisor.builder()
                .name(supervisor.getName())
                .email(supervisor.getEmail())
                .password(supervisor.getPassword())
                .paladya(paladyaRepository.findPaladyaById(supervisor.getPaladyaId()))
                .build();
        supervisorRepository.save(sp);
        return sp;
    }
}
