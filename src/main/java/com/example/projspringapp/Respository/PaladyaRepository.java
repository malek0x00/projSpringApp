package com.example.projspringapp.Respository;

import com.example.projspringapp.Model.Paladya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaladyaRepository  extends JpaRepository<Paladya, Long> {
    public Paladya save(Paladya paladya);
    public Paladya findPaladyaById(long id);
}
