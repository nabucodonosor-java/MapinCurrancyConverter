package com.mapin.currancyconvert.dto;

import com.mapin.currancyconvert.model.Quote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QuoteBIDByDateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate date;
    private Double bid;

    public QuoteBIDByDateDTO(Quote obj) {
        date = obj.getDate();
        bid = obj.getBid();
    }
}
