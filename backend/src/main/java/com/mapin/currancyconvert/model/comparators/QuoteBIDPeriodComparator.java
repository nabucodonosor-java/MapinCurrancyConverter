package com.mapin.currancyconvert.model.comparators;

import com.mapin.currancyconvert.dto.QuoteBIDByDateDTO;

import java.util.Comparator;

public class QuoteBIDPeriodComparator implements Comparator<QuoteBIDByDateDTO> {

    @Override
    public int compare(QuoteBIDByDateDTO q1, QuoteBIDByDateDTO q2) {

        return q1.getDate().compareTo(q2.getDate());
    }

}
