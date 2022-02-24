package com.mapin.currancyconvert.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mapin.currancyconvert.dto.QuoteDTO;
import com.mapin.currancyconvert.model.Quote;
import com.mapin.currancyconvert.model.enums.QuoteStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mapin.currancyconvert.repositories.QuoteRepository;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

//    @Transactional(readOnly = true)
//    public Page<QuoteDTO> sales(String minDate, String maxDate, String quoteStatus, Pageable pageable) {
//        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
//        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
//        QuoteStatus quoteEnum = "".equals(quoteStatus) ? null : QuoteStatus.valueOf(quoteStatus);
//        Page<Quote> page = quoteRepository.searchPage(min, max, quoteStatus, pageable);
//        quoteRepository.quotesWithOtherEntities(page.getContent());
//        return page.map(x -> new QuoteDTO(x));
//    }

    @Transactional(readOnly = true)
    public Page<QuoteDTO> findAllDollarQuotes(Pageable pageable) {
        Page<Quote> quotes = quoteRepository.findAllDollarQuotes(pageable);
        return QuoteDTO.converter(quotes);
    }

    @Transactional(readOnly = true)
    public Page<QuoteDTO> findAllEuroQuotes(Pageable pageable) {
        Page<Quote> quotes = quoteRepository.findAllEuroQuotes(pageable);
        return QuoteDTO.converter(quotes);
    }

    @Transactional(readOnly = true)
    public Page<QuoteDTO> findAllBitcoinQuotes(Pageable pageable) {
        Page<Quote> quotes = quoteRepository.findAllBitcoinQuotes(pageable);
        return QuoteDTO.converter(quotes);
    }

    @Transactional(readOnly = true)
    public Page<QuoteDTO> findAllDollarQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDateTime min = "".equals(minDate) ? null : LocalDateTime.parse(minDate);
        LocalDateTime max = "".equals(maxDate) ? null : LocalDateTime.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllDollarQuotesByPeriod(min, max, pageable);
        return QuoteDTO.converter(page);
    }

    @Transactional(readOnly = true)
    public Page<QuoteDTO> findAllEuroQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDateTime min = "".equals(minDate) ? null : LocalDateTime.parse(minDate);
        LocalDateTime max = "".equals(maxDate) ? null : LocalDateTime.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllEuroQuotesByPeriod(min, max, pageable);
        return QuoteDTO.converter(page);
    }

    @Transactional(readOnly = true)
    public Page<QuoteDTO> findAllBitcoinQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDateTime min = "".equals(minDate) ? null : LocalDateTime.parse(minDate);
        LocalDateTime max = "".equals(maxDate) ? null : LocalDateTime.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllBitcoinQuotesByPeriod(min, max, pageable);
        return QuoteDTO.converter(page);
    }
}
