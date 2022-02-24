package com.mapin.currancyconvert.dto;

import com.mapin.currancyconvert.model.Quote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BIDQuoteDashDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate date;
    private Double bid;

    public BIDQuoteDashDTO(Quote obj) {
        date = obj.getDate();
        bid = obj.getBid();
    }

    public static Page<BIDQuoteDashDTO> converter(Page<Quote> page) {
        return page.map(BIDQuoteDashDTO::new);
    }
}
