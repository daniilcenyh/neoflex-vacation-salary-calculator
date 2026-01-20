package com.hamming.calculate_vacation_salary.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CalculateVacationSalaryService {
    BigDecimal calculate(BigDecimal averageSalary, Integer vacationDays, LocalDate startDate);
}
