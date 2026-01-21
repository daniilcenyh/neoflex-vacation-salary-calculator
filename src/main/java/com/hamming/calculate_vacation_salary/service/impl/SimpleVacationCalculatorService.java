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
public class SimpleVacationCalculatorService implements CalculateVacationSalaryService {
    private static final BigDecimal AVG_DAYS_IN_MONTH = new BigDecimal("29.3");

    @Override
    public BigDecimal calculate(BigDecimal averageSalary, Integer vacationDays, LocalDate startDate) {
        log.info("Начало расчета отпускных (простой метод). Параметры: средняя зарплата = {}, " +
                "дни отпуска = {}, дата начала = {}", averageSalary, vacationDays, startDate);

        BigDecimal dailyAverage = averageSalary.divide(AVG_DAYS_IN_MONTH, 2, RoundingMode.HALF_UP);
        log.debug("Среднедневной заработок: {}", dailyAverage);

        BigDecimal result = dailyAverage.multiply(new BigDecimal(vacationDays));

        log.info("Расчет отпускных завершен. Результат: {} ({} дней × {} средний дневной заработок)",
                result, vacationDays, dailyAverage);

        return result;
    }
}
