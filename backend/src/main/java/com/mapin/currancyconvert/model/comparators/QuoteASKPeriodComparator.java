package com.mapin.currancyconvert.model.comparators;

import com.mapin.currancyconvert.dto.QuoteASKByDateDTO;
import com.mapin.currancyconvert.dto.QuoteBIDByDateDTO;

import java.util.Comparator;

public class QuoteASKPeriodComparator implements Comparator<QuoteASKByDateDTO> {

    @Override
    public int compare(QuoteASKByDateDTO q1, QuoteASKByDateDTO q2) {

        return q1.getDate().compareTo(q2.getDate());
    }

}
