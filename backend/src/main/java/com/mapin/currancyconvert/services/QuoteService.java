package com.mapin.currancyconvert.services;

import com.mapin.currancyconvert.dto.QuoteASKByDateDTO;
import com.mapin.currancyconvert.dto.QuoteBIDByDateDTO;
import com.mapin.currancyconvert.dto.QuoteDTO;
import com.mapin.currancyconvert.model.Quote;
import com.mapin.currancyconvert.model.comparators.QuoteASKPeriodComparator;
import com.mapin.currancyconvert.model.comparators.QuoteBIDPeriodComparator;
import com.mapin.currancyconvert.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Transactional(readOnly = true)
    public Page<QuoteDTO> findAllWithFilters(String minDate, String maxDate, String currancy, Pageable pageable) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllWithFilters(min, max, currancy, pageable);
        return QuoteDTO.converter(page);
    }

    @Transactional(readOnly = true)
    public List<QuoteBIDByDateDTO> dashboardBIDByDate(String minDate, String maxDate, String currancy) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        List<QuoteBIDByDateDTO> list = quoteRepository.dashboardBIDByDate(min, max, currancy);
        Collections.sort(list, new QuoteBIDPeriodComparator());
        return list;
    }

    @Transactional(readOnly = true)
    public List<QuoteASKByDateDTO> dashboardASKByDate(String minDate, String maxDate, String currancy) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        List<QuoteASKByDateDTO> list = quoteRepository.dashboardASKByDate(min, max, currancy);
        Collections.sort(list, new QuoteASKPeriodComparator());
        return list;
    }
}
