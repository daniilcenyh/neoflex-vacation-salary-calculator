package com.hamming.calculate_vacation_salary.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VacationCalculateRequest(
        @NotNull
        @PositiveOrZero
        BigDecimal averageSalary,
        @NotNull
        @PositiveOrZero
        Integer vacationDays,
        LocalDate startVacation
) {
}
