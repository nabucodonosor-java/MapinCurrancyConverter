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
public class ASKQuoteDashDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate date;
    private Double ask;

    public ASKQuoteDashDTO(Quote obj) {
        date = obj.getDate();
        ask = obj.getAsk();
    }

    public static Page<ASKQuoteDashDTO> converter(Page<Quote> page) {
        return page.map(ASKQuoteDashDTO::new);
    }
}
