package com.mapin.currancyconvert.model;


import com.mapin.currancyconvert.model.enums.QuoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_cotacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private String code;
    private String name;
    private Double bid;
    private Double ask;
    private Double high;
    private Double low;
}
