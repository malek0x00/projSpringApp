package com.example.projspringapp.RestController;

import com.example.projspringapp.Model.Paladya;
import com.example.projspringapp.Respository.PaladyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaladyaController {
    @Autowired
    PaladyaRepository paladyaRepository;

    @PostMapping("/paladya")
    public Paladya addPaladya(@RequestBody Paladya paladya){
        paladyaRepository.save(paladya);
        return paladya;
    }

    @GetMapping("/paladyas")
    public Iterable<Paladya> getAllPaladyas(){
        return paladyaRepository.findAll();
    }
}
