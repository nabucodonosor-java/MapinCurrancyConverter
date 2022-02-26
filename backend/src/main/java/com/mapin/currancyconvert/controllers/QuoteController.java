package com.mapin.currancyconvert.controllers;

import com.mapin.currancyconvert.dto.QuoteASKByDateDTO;
import com.mapin.currancyconvert.dto.QuoteBIDByDateDTO;
import com.mapin.currancyconvert.dto.QuoteDTO;
import com.mapin.currancyconvert.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping(value = "/current-usd")
    public ResponseEntity<QuoteDTO> currentUSDQuote() throws IOException {
        QuoteDTO obj = quoteService.currentUSDQuote();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/current-eur")
    public ResponseEntity<QuoteDTO> currentEURQuote() throws IOException {
        QuoteDTO obj = quoteService.currentEURQuote();
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<Page<QuoteDTO>> findAllWithFilters(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            @RequestParam(value = "currancy", defaultValue = "USD") String currancy,
            Pageable pageable) {
        Page<QuoteDTO> page = quoteService.findAllWithFilters(minDate, maxDate, currancy, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/by-date")
    public ResponseEntity<List<QuoteBIDByDateDTO>> dashboardBIDByDate(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            @RequestParam(value = "currancy", defaultValue = "USD") String currancy) {
        List<QuoteBIDByDateDTO> list = quoteService.dashboardBIDByDate(minDate, maxDate, currancy);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/ask/by-date")
    public ResponseEntity<List<QuoteASKByDateDTO>> dashboardASKByDate(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            @RequestParam(value = "currancy", defaultValue = "USD") String currancy) {
        List<QuoteASKByDateDTO> list = quoteService.dashboardASKByDate(minDate, maxDate, currancy);
        return ResponseEntity.ok(list);
    }
}
