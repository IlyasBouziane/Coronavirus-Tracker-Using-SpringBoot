package com.corona.coronavirustracker.controllers;


import com.corona.coronavirustracker.services.CoronaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    CoronaDataService coronaDataService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("locationStats",coronaDataService.getAllStats());
        System.out.println("sdsdssdsssssssssssssssssssssss"+ coronaDataService.getAllStats().isEmpty());
        return "main";
    }

}
