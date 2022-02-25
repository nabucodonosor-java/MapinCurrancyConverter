package com.mapin.currancyconvert.services;

import com.mapin.currancyconvert.dto.QuoteBIDByDateDTO;
import com.mapin.currancyconvert.model.comparators.QuotePeriodComparator;
import com.mapin.currancyconvert.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<QuoteBIDByDateDTO> dashboardBIDByDate(String minDate, String maxDate, String currancy) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        List<QuoteBIDByDateDTO> list = quoteRepository.dashboardBIDByDate(min, max, currancy);
        Collections.sort(list, new QuotePeriodComparator());
        return list;
    }
}
