package com.heartdisease.controller;

import com.heartdisease.model.Patient;
import com.heartdisease.service.HeartDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HeartDiseaseController {

    @Autowired
    private HeartDiseaseService heartDiseaseService;

    @GetMapping("/")
    public String index(Model model) {
        List<Patient> patients = heartDiseaseService.getAllPatients();
        model.addAttribute("patients", patients);
        return "index";
    }

    @PostMapping("/predict")
    public String predict(@ModelAttribute Patient patient, Model model) {
        String result = heartDiseaseService.predictHeartDisease(patient);
        model.addAttribute("result", result);
        return "result";
    }
}
