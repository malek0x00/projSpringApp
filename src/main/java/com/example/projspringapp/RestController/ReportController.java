package com.example.projspringapp.RestController;

import com.example.projspringapp.DTO.ReportRequestDTO;
import com.example.projspringapp.Model.Paladya;
import com.example.projspringapp.Model.Report;
import com.example.projspringapp.Model.User;
import com.example.projspringapp.Respository.PaladyaRepository;
import com.example.projspringapp.Respository.ReportRepository;
import com.example.projspringapp.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportController {
    @Autowired
    ReportRepository reportRepository;
    @Autowired
    PaladyaRepository paladyaRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/reports/{id}")
    public List<Report> getReportsByUserId(@PathVariable Long id){
        return reportRepository.findReportByUserId(id);
    }

    @PostMapping("/report")
    public Report createReport(@RequestBody ReportRequestDTO reportRequest){
        Report r = Report.builder()
                .description(reportRequest.getDescription())
                .image(reportRequest.getImage())
                .latitude(reportRequest.getLatitude())
                .longitude(reportRequest.getLongitude())
                .status(reportRequest.getStatus())
                .type(reportRequest.getType())
                .user(userRepository.findUserById(reportRequest.getUserId()))
                .city(paladyaRepository.findPaladyaById(reportRequest.getPaladyaId()))
                .build();

        System.out.println(r);
        reportRepository.save(r);
        return r;
    }
    @GetMapping("viewreport/{reportId}")
    public Report getReportByReportId(@PathVariable Long reportId){
        return reportRepository.findReportById(reportId);

    }



}
