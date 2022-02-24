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
public class QuoteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate date;
    private Double bid;
    private Double ask;
    private Double high;
    private Double low;
    private String code;
    private String name;

    public QuoteDTO(Quote obj) {
        id = obj.getId();
        date = obj.getDate();
        bid = obj.getBid();
        ask = obj.getAsk();
        high = obj.getHigh();
        low = obj.getLow();
        code = obj.getCode();
        name = obj.getName();
    }

    public static Page<QuoteDTO> converter(Page<Quote> page) {
        return page.map(QuoteDTO::new);
    }
}
