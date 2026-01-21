package com.hamming.calculate_vacation_salary.repository;

import com.hamming.calculate_vacation_salary.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {

    @Query("SELECT h FROM Holiday h WHERE h.date = :date")
    Optional<Holiday> findByDate(@Param("date") LocalDate date);

    @Query("SELECT h FROM Holiday h WHERE h.date BETWEEN :startDate AND :endDate")
    List<Holiday> findHolidaysBetweenDates(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
