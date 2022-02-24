package com.mapin.currancyconvert.controllers;

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

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping(value = "/dolar")
    public ResponseEntity<Page<QuoteDTO>> findALlDollarQuotes(Pageable page) {
        Page<QuoteDTO> list = quoteService.findAllDollarQuotes(page);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/dolar/periodo")
    public ResponseEntity<Page<QuoteDTO>> findAllDollarQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<QuoteDTO> page = quoteService.findAllDollarQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/euro")
    public ResponseEntity<Page<QuoteDTO>> findAllEuroQuotes(Pageable page) {
        Page<QuoteDTO> list = quoteService.findAllEuroQuotes(page);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/euro/periodo")
    public ResponseEntity<Page<QuoteDTO>> findAllEuroQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<QuoteDTO> page = quoteService.findAllEuroQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/bitcoin")
    public ResponseEntity<Page<QuoteDTO>> findAllBitcoinQuotes(Pageable page) {
        Page<QuoteDTO> list = quoteService.findAllBitcoinQuotes(page);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/bitcoin/periodo")
    public ResponseEntity<Page<QuoteDTO>> findAllBitcoinQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<QuoteDTO> page = quoteService.findAllBitcoinQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }
}
