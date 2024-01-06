package com.example.projspringapp.Respository;

import com.example.projspringapp.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    public Report save(Report report);
    public List<Report> findReportByUserId(Long id);

    public Report findReportById(Long id);
}
