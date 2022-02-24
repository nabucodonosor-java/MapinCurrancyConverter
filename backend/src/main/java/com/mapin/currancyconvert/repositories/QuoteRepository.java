package com.mapin.currancyconvert.repositories;

import com.mapin.currancyconvert.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"USD\"'")
    Page<Quote> findAllDollarQuotes(Pageable pageable);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"EUR\"'")
    Page<Quote> findAllEuroQuotes(Pageable pageable);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"BTC\"'")
    Page<Quote> findAllBitcoinQuotes(Pageable pageable);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"USD\"' " +
            "AND (CAST(:min AS date) IS NULL OR obj.date >= :min) " +
            "AND (CAST(:max AS date) IS NULL OR obj.date <= :max)")
    Page<Quote> findAllDollarQuotesByPeriod(LocalDateTime min, LocalDateTime max, Pageable pageable);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"EUR\"' " +
            "AND (CAST(:min AS date) IS NULL OR obj.date >= :min) " +
            "AND (CAST(:max AS date) IS NULL OR obj.date <= :max)")
    Page<Quote> findAllEuroQuotesByPeriod(LocalDateTime min, LocalDateTime max, Pageable pageable);

    @Query("SELECT obj FROM Quote AS obj WHERE obj.code = '\"BTC\"' " +
            "AND (CAST(:min AS date) IS NULL OR obj.date >= :min) " +
            "AND (CAST(:max AS date) IS NULL OR obj.date <= :max)")
    Page<Quote> findAllBitcoinQuotesByPeriod(LocalDateTime min, LocalDateTime max, Pageable pageable);
}