package com.mapin.currancyconvert.model.comparators;

import com.mapin.currancyconvert.dto.QuoteBIDByDateDTO;
import com.mapin.currancyconvert.model.Quote;

import java.util.Comparator;

public class QuotePeriodComparator implements Comparator<QuoteBIDByDateDTO> {

    @Override
    public int compare(QuoteBIDByDateDTO q1, QuoteBIDByDateDTO q2) {

        return q2.getDate().compareTo(q1.getDate());
    }

}
