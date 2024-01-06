package com.example.projspringapp.Respository;

import com.example.projspringapp.Model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
    public Supervisor save(Supervisor supervisor);
    public List<Supervisor> findAllByPaladyaId(Long id);
}
