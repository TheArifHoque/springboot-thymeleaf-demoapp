package com.arifhoque.main.controller;

import com.arifhoque.main.model.Candidate;
import com.arifhoque.main.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/home")
    public String homePage(){
        return "home-page.html";
    }

    @PostMapping("/find-by-id")
    public String findById(@RequestParam Integer id, Model model, RedirectAttributes redirectAttributes){
        Candidate candidate = candidateService.findById(id);
        if (candidate==null){
            redirectAttributes.addFlashAttribute("error","No candidate found");
            return "redirect:/home";
        }
        model.addAttribute("candidate",candidate);
        return "candidate-page.html";
    }

    @GetMapping("/add-candidate")
    public String addCandidate(){
        return "add-candidate-page.html";
    }

    @PostMapping("/add-candidate")
    public String addCandidate(@ModelAttribute Candidate candidate){
        candidateService.addCandidate(candidate);
        return "redirect:/home";
    }

    @GetMapping("/list-all-candidates")
    public String listAllCandidates(Model model){
        model.addAttribute("candidateList",candidateService.getAllCandidate());
        return "all-candidates-page.html";
    }
}
