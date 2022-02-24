package com.mapin.currancyconvert.controllers;

import com.mapin.currancyconvert.dto.*;
import com.mapin.currancyconvert.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /*
        endpoint para gráfico
        COMPRA DÓLAR
     */
    @GetMapping(value = "/dash/dolar/bid")
    public ResponseEntity<List<BIDQuoteDashDTO>> dashboardDolarBID(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        List<BIDQuoteDashDTO> page = quoteService.dashboardDolarBID(minDate, maxDate);
        return ResponseEntity.ok(page);
    }

    /*
        endpoint para gráfico
        VENDA DÓLAR
     */
    @GetMapping(value = "/dash/dolar/ask")
    public ResponseEntity<List<ASKQuoteDashDTO>> dashboardDolarASK(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        List<ASKQuoteDashDTO> page = quoteService.dashboardDolarASK(minDate, maxDate);
        return ResponseEntity.ok(page);
    }

    /*
        endpoint para datatable
        DÓLAR VENDA e COMPRA por período
     */
    @GetMapping(value = "/dolar/periodo")
    public ResponseEntity<Page<QuoteDTO>> findAllDollarQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<QuoteDTO> page = quoteService.findAllDollarQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    /*
        endpoint para datatable
        DÓLAR VENDA por período
     */
    @GetMapping(value = "/dolar/periodo/bid")
    public ResponseEntity<Page<BIDQuoteDTO>> findAllDolarBIDQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<BIDQuoteDTO> page = quoteService.findAllDolarBIDQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    /*
        endpoint para datatable
        DÓLAR COMPRA por período
     */
    @GetMapping(value = "/dolar/periodo/ask")
    public ResponseEntity<Page<ASKQuoteDTO>> findAllDolarASKQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<ASKQuoteDTO> page = quoteService.findAllDolarASKQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

   // EURO

    /*
        endpoint para gráfico
        COMPRA EURO
     */
    @GetMapping(value = "/dash/euro/bid")
    public ResponseEntity<List<BIDQuoteDashDTO>> dashboardEuroBID(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        List<BIDQuoteDashDTO> page = quoteService.dashboardEuroBID(minDate, maxDate);
        return ResponseEntity.ok(page);
    }

    /*
        endpoint para gráfico
        VENDA EURO
     */
    @GetMapping(value = "/dash/euro/ask")
    public ResponseEntity<List<ASKQuoteDashDTO>> dashboardEuroASK(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        List<ASKQuoteDashDTO> page = quoteService.dashboardEuroASK(minDate, maxDate);
        return ResponseEntity.ok(page);
    }

    /*
        endpoint para datatable
        EURO VENDA e COMPRA por período
     */
    @GetMapping(value = "/euro/periodo")
    public ResponseEntity<Page<QuoteDTO>> findAllEuroQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<QuoteDTO> page = quoteService.findAllEuroQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    /*
       endpoint para datatable
       EURO VENDA por período
    */
    @GetMapping(value = "/euro/periodo/bid")
    public ResponseEntity<Page<BIDQuoteDTO>> findAllEuroBIDQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<BIDQuoteDTO> page = quoteService.findAllEuroBIDQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }

    /*
       endpoint para datatable
       DÓLAR COMPRA por período
    */
    @GetMapping(value = "/euro/periodo/ask")
    public ResponseEntity<Page<ASKQuoteDTO>> findAllEuroASKQuotesByPeriod(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<ASKQuoteDTO> page = quoteService.findAllEuroASKQuotesByPeriod(minDate, maxDate, pageable);
        return ResponseEntity.ok(page);
    }
}
