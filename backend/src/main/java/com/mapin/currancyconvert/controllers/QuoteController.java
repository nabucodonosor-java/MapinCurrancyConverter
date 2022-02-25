package com.mapin.currancyconvert.controllers;

import com.mapin.currancyconvert.dto.QuoteBIDByDateDTO;
import com.mapin.currancyconvert.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping(value = "/by-date")
    public ResponseEntity<List<QuoteBIDByDateDTO>> dashboardBIDByDate(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            @RequestParam(value = "currancy", defaultValue = "") String currancy) {
        List<QuoteBIDByDateDTO> list = quoteService.dashboardBIDByDate(minDate, maxDate, currancy);
        return ResponseEntity.ok(list);
    }
}
