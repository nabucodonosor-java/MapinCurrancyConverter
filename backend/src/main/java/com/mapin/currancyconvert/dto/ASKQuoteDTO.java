package com.mapin.currancyconvert.dto;

import com.mapin.currancyconvert.model.Quote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ASKQuoteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime date;
    private Double ask;
    private String code;
    private String name;

    public ASKQuoteDTO(Quote obj) {
        id = obj.getId();
        date = obj.getDate();
        ask = obj.getAsk();
        code = obj.getCode();
        name = obj.getName();
    }

    public static Page<ASKQuoteDTO> converter(Page<Quote> page) {
        return page.map(ASKQuoteDTO::new);
    }
}
