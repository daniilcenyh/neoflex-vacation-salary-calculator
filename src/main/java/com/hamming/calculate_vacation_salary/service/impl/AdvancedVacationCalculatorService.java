package com.hamming.calculate_vacation_salary.service.impl;

import com.hamming.calculate_vacation_salary.service.CalculateVacationSalaryService;
import com.hamming.calculate_vacation_salary.service.HolidayService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdvancedVacationCalculatorService implements CalculateVacationSalaryService {

    @Value("${avg.days-in-month}")
    private static String AVG_DAYS_VALUE;
    private static final BigDecimal AVG_DAYS_IN_MONTH = new BigDecimal(AVG_DAYS_VALUE);

    private final HolidayService holidayService;

    @Override
    public BigDecimal calculate(BigDecimal averageSalary, Integer vacationDays, LocalDate startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date is required for advanced calculation");
        }
        int paidDays = calculatePaidDays(startDate, vacationDays);

        BigDecimal dailyAverage = averageSalary.divide(AVG_DAYS_IN_MONTH, 2, RoundingMode.HALF_UP);
        return dailyAverage.multiply(new BigDecimal(paidDays));
    }

    private int calculatePaidDays(LocalDate start, int vacationDays) {
        int paidDays = 0;
        LocalDate current = start;

        while (paidDays < vacationDays) {
            if (!holidayService.isHoliday(current)) {
                paidDays++;
            }
            current = current.plusDays(1);
        }
        return paidDays;
    }
}
