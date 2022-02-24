package com.mapin.currancyconvert.services;

import java.time.LocalDateTime;

import com.mapin.currancyconvert.dto.ASKQuoteDTO;
import com.mapin.currancyconvert.dto.BIDQuoteDTO;
import com.mapin.currancyconvert.dto.QuoteDTO;
import com.mapin.currancyconvert.model.Quote;
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

    @Transactional(readOnly = true)
    public Page<BIDQuoteDTO> findAllDolarBIDQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDateTime min = "".equals(minDate) ? null : LocalDateTime.parse(minDate);
        LocalDateTime max = "".equals(maxDate) ? null : LocalDateTime.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllDollarQuotesByPeriod(min, max, pageable);
        return BIDQuoteDTO.converter(page);
    }

    @Transactional(readOnly = true)
    public Page<ASKQuoteDTO> findAllDolarASKQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDateTime min = "".equals(minDate) ? null : LocalDateTime.parse(minDate);
        LocalDateTime max = "".equals(maxDate) ? null : LocalDateTime.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllDollarQuotesByPeriod(min, max, pageable);
        return ASKQuoteDTO.converter(page);
    }

    @Transactional(readOnly = true)
    public Page<BIDQuoteDTO> findAllEuroBIDQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDateTime min = "".equals(minDate) ? null : LocalDateTime.parse(minDate);
        LocalDateTime max = "".equals(maxDate) ? null : LocalDateTime.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllEuroQuotesByPeriod(min, max, pageable);
        return BIDQuoteDTO.converter(page);
    }

    @Transactional(readOnly = true)
    public Page<ASKQuoteDTO> findAllEuroASKQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDateTime min = "".equals(minDate) ? null : LocalDateTime.parse(minDate);
        LocalDateTime max = "".equals(maxDate) ? null : LocalDateTime.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllEuroQuotesByPeriod(min, max, pageable);
        return ASKQuoteDTO.converter(page);
    }

    @Transactional(readOnly = true)
    public Page<BIDQuoteDTO> findAllBitcoinBIDQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDateTime min = "".equals(minDate) ? null : LocalDateTime.parse(minDate);
        LocalDateTime max = "".equals(maxDate) ? null : LocalDateTime.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllBitcoinQuotesByPeriod(min, max, pageable);
        return BIDQuoteDTO.converter(page);
    }

    @Transactional(readOnly = true)
    public Page<ASKQuoteDTO> findAllBitcoinASKQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDateTime min = "".equals(minDate) ? null : LocalDateTime.parse(minDate);
        LocalDateTime max = "".equals(maxDate) ? null : LocalDateTime.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllBitcoinQuotesByPeriod(min, max, pageable);
        return ASKQuoteDTO.converter(page);
    }
}
