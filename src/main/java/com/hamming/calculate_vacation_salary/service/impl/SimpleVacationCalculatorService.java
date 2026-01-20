package com.hamming.calculate_vacation_salary.service.impl;

import com.hamming.calculate_vacation_salary.service.CalculateVacationSalaryService;
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
public class SimpleVacationCalculatorService implements CalculateVacationSalaryService {

    @Value("${avg.days-in-month}")
    private static String AVG_DAYS_VALUE;
    private static final BigDecimal AVG_DAYS_IN_MONTH = new BigDecimal(AVG_DAYS_VALUE);

    @Override
    public BigDecimal calculate(BigDecimal averageSalary, Integer vacationDays, LocalDate startDate) {
        BigDecimal dailyAverage = averageSalary.divide(AVG_DAYS_IN_MONTH, 2, RoundingMode.HALF_UP);
        return dailyAverage.multiply(new BigDecimal(vacationDays));
    }
}
