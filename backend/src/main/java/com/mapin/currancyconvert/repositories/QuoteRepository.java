package com.mapin.currancyconvert.repositories;

import com.mapin.currancyconvert.dto.QuoteBIDByDateDTO;
import com.mapin.currancyconvert.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query("SELECT new com.mapin.currancyconvert.dto.QuoteBIDByDateDTO(obj.date, obj.bid) "
            + "FROM Quote AS obj "
            + "WHERE (CAST(:min AS date) IS NULL OR obj.date >= :min) "
            + "AND (CAST(:max AS date) IS NULL OR obj.date <= :max) "
            + "AND (LOWER(obj.code) LIKE LOWER(CONCAT('%',:currancy,'%')))")
    List<QuoteBIDByDateDTO> dashboardBIDByDate(LocalDate min, LocalDate max, String currancy);
}