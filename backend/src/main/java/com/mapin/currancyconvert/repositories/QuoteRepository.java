package com.mapin.currancyconvert.repositories;

import com.mapin.currancyconvert.dto.ASKQuoteDashDTO;
import com.mapin.currancyconvert.dto.BIDQuoteDashDTO;
import com.mapin.currancyconvert.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query("SELECT new com.mapin.currancyconvert.dto.ASKQuoteDashDTO(obj.date, obj.ask) "
            + "FROM Quote AS obj "
            + "WHERE (CAST(:min AS date) IS NULL OR obj.date >= :min) "
            + "AND (CAST(:max AS date) IS NULL OR obj.date <= :max) "
            + "AND obj.code = '\"USD\"'")
    List<ASKQuoteDashDTO> dashboardDolarASK(LocalDate min, LocalDate max);

    @Query("SELECT new com.mapin.currancyconvert.dto.ASKQuoteDashDTO(obj.date, obj.ask) "
            + "FROM Quote AS obj "
            + "WHERE (CAST(:min AS date) IS NULL OR obj.date >= :min) "
            + "AND (CAST(:max AS date) IS NULL OR obj.date <= :max) "
            + "AND obj.code = '\"EUR\"'")
    List<ASKQuoteDashDTO> dashboardEuroASK(LocalDate min, LocalDate max);

    @Query("SELECT new com.mapin.currancyconvert.dto.BIDQuoteDashDTO(obj.date, obj.bid) "
            + "FROM Quote AS obj "
            + "WHERE (CAST(:min AS date) IS NULL OR obj.date >= :min) "
            + "AND (CAST(:max AS date) IS NULL OR obj.date <= :max) "
            + "AND obj.code = '\"USD\"'")
    List<BIDQuoteDashDTO> dashboardDolarBID(LocalDate min, LocalDate max);

    @Query("SELECT new com.mapin.currancyconvert.dto.BIDQuoteDashDTO(obj.date, obj.bid) "
            + "FROM Quote AS obj "
            + "WHERE (CAST(:min AS date) IS NULL OR obj.date >= :min) "
            + "AND (CAST(:max AS date) IS NULL OR obj.date <= :max) "
            + "AND obj.code = '\"EUR\"'")
    List<BIDQuoteDashDTO> dashboardEuroBID(LocalDate min, LocalDate max);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"USD\"'")
    Page<Quote> findAllDollarQuotes(Pageable pageable);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"EUR\"'")
    Page<Quote> findAllEuroQuotes(Pageable pageable);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"BTC\"'")
    Page<Quote> findAllBitcoinQuotes(Pageable pageable);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"USD\"' " +
            "AND (CAST(:min AS date) IS NULL OR obj.date >= :min) " +
            "AND (CAST(:max AS date) IS NULL OR obj.date <= :max)")
    Page<Quote> findAllDollarQuotesByPeriod(LocalDate min, LocalDate max, Pageable pageable);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"EUR\"' " +
            "AND (CAST(:min AS date) IS NULL OR obj.date >= :min) " +
            "AND (CAST(:max AS date) IS NULL OR obj.date <= :max)")
    Page<Quote> findAllEuroQuotesByPeriod(LocalDate min, LocalDate max, Pageable pageable);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"BTC\"' " +
            "AND (CAST(:min AS date) IS NULL OR obj.date >= :min) " +
            "AND (CAST(:max AS date) IS NULL OR obj.date <= :max)")
    Page<Quote> findAllBitcoinQuotesByPeriod(LocalDate min, LocalDate max, Pageable pageable);
}