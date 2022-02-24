package com.mapin.currancyconvert.model.comparators;

import com.mapin.currancyconvert.dto.BIDQuoteDashDTO;

import java.util.Comparator;

public class QuotePeriodComparatorBID implements Comparator<BIDQuoteDashDTO> {

    @Override
    public int compare(BIDQuoteDashDTO q1, BIDQuoteDashDTO q2) {

        return q2.getDate().compareTo(q1.getDate());
    }

}
