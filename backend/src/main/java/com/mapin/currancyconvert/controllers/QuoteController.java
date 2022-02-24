package com.mapin.currancyconvert.controllers;

import com.mapin.currancyconvert.dto.ASKQuoteDTO;
import com.mapin.currancyconvert.dto.BIDQuoteDTO;
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

    @GetMapping(value = "/dolar/periodo")
    public ResponseEntity<Page<QuoteDTO>> findAllDollarQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<QuoteDTO> page = quoteService.findAllDollarQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/dolar/periodo/bid")
    public ResponseEntity<Page<BIDQuoteDTO>> findAllDolarBIDQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<BIDQuoteDTO> page = quoteService.findAllDolarBIDQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/dolar/periodo/ask")
    public ResponseEntity<Page<ASKQuoteDTO>> findAllDolarASKQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<ASKQuoteDTO> page = quoteService.findAllDolarASKQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/euro/periodo")
    public ResponseEntity<Page<QuoteDTO>> findAllEuroQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<QuoteDTO> page = quoteService.findAllEuroQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/euro/periodo/bid")
    public ResponseEntity<Page<BIDQuoteDTO>> findAllEuroBIDQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<BIDQuoteDTO> page = quoteService.findAllEuroBIDQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/euro/periodo/ask")
    public ResponseEntity<Page<ASKQuoteDTO>> findAllEuroASKQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<ASKQuoteDTO> page = quoteService.findAllEuroASKQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/bitcoin/periodo")
    public ResponseEntity<Page<QuoteDTO>> findAllBitcoinQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<QuoteDTO> page = quoteService.findAllBitcoinQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/bitcoin/periodo/bid")
    public ResponseEntity<Page<BIDQuoteDTO>> findAllBitcoinBIDQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<BIDQuoteDTO> page = quoteService.findAllBitcoinBIDQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/bitcoin/periodo/ask")
    public ResponseEntity<Page<ASKQuoteDTO>> findAllBitcoinASKQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<ASKQuoteDTO> page = quoteService.findAllBitcoinASKQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }
}
