package com.example.projspringapp.Controller;

import com.example.projspringapp.Model.Report;
import com.example.projspringapp.Respository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ReportMvcController {
    @Autowired
    ReportRepository reportRepository;
    @GetMapping("/reports")
    public String getReports(Model m){
        List<Report> reports = reportRepository.findAll();
        m.addAttribute("reports", reports);
        return "reports";
    }

    @GetMapping("/reports/{id}")
    public String getReportsByUserId(Model m, @PathVariable Long id){
        Report report = reportRepository.findReportById(id);
        m.addAttribute("report", report);
        return "reportbyid";
    }

    @GetMapping("/reports/delete/{id}")
    public String deleteReport(Model m, @PathVariable Long id){
        reportRepository.deleteById(id);
        return "redirect:/reports";
    }

}
