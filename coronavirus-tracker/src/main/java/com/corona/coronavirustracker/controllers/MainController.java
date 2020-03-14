package com.corona.coronavirustracker.controllers;


import com.corona.coronavirustracker.models.LocationStats;
import com.corona.coronavirustracker.services.CoronaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    CoronaDataService coronaDataService;

    @GetMapping("/")
    public String main(Model model){
        ArrayList<LocationStats> locationStats = coronaDataService.getAllStats();
        int totalCasesReported = locationStats.stream().mapToInt(locationStat -> locationStat.getLatestTotalCases()).sum();
        /**
         * I choose to put totalCasesReported in the controller and not in the service part
         * because it's a UI matter and i won't need this attribute anywhere else
         */
        model.addAttribute("totalCasesReported",totalCasesReported);
        int newCasesReported = locationStats.stream().mapToInt(locationStat -> locationStat.getAddedSincePrevDay()).sum();
        model.addAttribute("newCasesReported",newCasesReported);
        model.addAttribute("locationStats",locationStats);

        return "main";
    }

}
