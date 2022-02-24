package com.mapin.currancyconvert.model.comparators;

import com.mapin.currancyconvert.dto.ASKQuoteDashDTO;

import java.util.Comparator;

public class QuotePeriodComparatorASK implements Comparator<ASKQuoteDashDTO> {

    @Override
    public int compare(ASKQuoteDashDTO q1, ASKQuoteDashDTO q2) {

        return q2.getDate().compareTo(q1.getDate());
    }

}
