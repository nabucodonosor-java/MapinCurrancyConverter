package com.mapin.currancyconvert.services;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.mapin.currancyconvert.dto.*;
import com.mapin.currancyconvert.model.Quote;
import com.mapin.currancyconvert.model.comparators.QuotePeriodComparatorASK;
import com.mapin.currancyconvert.model.comparators.QuotePeriodComparatorBID;
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

    // endpoint /dash/dolar/bid
    @Transactional(readOnly = true)
    public List<BIDQuoteDashDTO> dashboardDolarBID(String minDate, String maxDate) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        List<BIDQuoteDashDTO> list = quoteRepository.dashboardDolarBID(min, max);
        Collections.sort(list, new QuotePeriodComparatorBID());
        return list;
    }

    // endpoint /dash/dolar/ask
    @Transactional(readOnly = true)
    public List<ASKQuoteDashDTO> dashboardDolarASK(String minDate, String maxDate) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        List<ASKQuoteDashDTO> list = quoteRepository.dashboardDolarASK(min, max);
        Collections.sort(list, new QuotePeriodComparatorASK());
        return list;
    }

    // endpoint /dolar/periodo
    @Transactional(readOnly = true)
    public Page<QuoteDTO> findAllDollarQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllDollarQuotesByPeriod(min, max, pageable);
        return QuoteDTO.converter(page);
    }

    // endpoint /dolar/periodo/bid
    @Transactional(readOnly = true)
    public Page<BIDQuoteDTO> findAllDolarBIDQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllDollarQuotesByPeriod(min, max, pageable);
        return BIDQuoteDTO.converter(page);
    }

    // endpoint /dolar/periodo/ask
    @Transactional(readOnly = true)
    public Page<ASKQuoteDTO> findAllDolarASKQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllDollarQuotesByPeriod(min, max, pageable);

        return ASKQuoteDTO.converter(page);
    }

    // EURO

    // endpoint /dash/euro/bid
    @Transactional(readOnly = true)
    public List<BIDQuoteDashDTO> dashboardEuroBID(String minDate, String maxDate) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        List<BIDQuoteDashDTO> list = quoteRepository.dashboardEuroBID(min, max);
        Collections.sort(list, new QuotePeriodComparatorBID());
        return list;
    }

    // endpoint /dash/euro/ask
    @Transactional(readOnly = true)
    public List<ASKQuoteDashDTO> dashboardEuroASK(String minDate, String maxDate) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        List<ASKQuoteDashDTO> list = quoteRepository.dashboardEuroASK(min, max);
        Collections.sort(list, new QuotePeriodComparatorASK());
        return list;
    }

    // endpoint /euro/periodo
    @Transactional(readOnly = true)
    public Page<QuoteDTO> findAllEuroQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllEuroQuotesByPeriod(min, max, pageable);
        return QuoteDTO.converter(page);
    }

    // endpoint /euro/periodo/bid
    @Transactional(readOnly = true)
    public Page<BIDQuoteDTO> findAllEuroBIDQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllEuroQuotesByPeriod(min, max, pageable);
        return BIDQuoteDTO.converter(page);
    }

    // endpoint /euro/periodo/ask
    @Transactional(readOnly = true)
    public Page<ASKQuoteDTO> findAllEuroASKQuotesByPeriod(String minDate, String maxDate, Pageable pageable) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllEuroQuotesByPeriod(min, max, pageable);

        return ASKQuoteDTO.converter(page);
    }

}
