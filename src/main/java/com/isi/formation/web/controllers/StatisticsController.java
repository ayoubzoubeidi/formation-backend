package com.isi.formation.web.controllers;

import com.isi.formation.services.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.isi.formation.web.controllers.ApiUrls.STATISTICS_MAIN_URL;

@Controller
@RequestMapping(STATISTICS_MAIN_URL)
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping
    public ResponseEntity<?> getDashboardStatistics() {
        return new ResponseEntity<>(statisticsService.getDashboardStatistics(), HttpStatus.OK);
    }

}
