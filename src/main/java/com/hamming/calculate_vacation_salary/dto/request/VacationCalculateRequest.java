package com.hamming.calculate_vacation_salary.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VacationCalculateRequest(
        @NotNull(message = "Average salary is required")
        @Positive(message = "Average salary must be positive")
        BigDecimal averageSalary,

        @NotNull(message = "Vacation days is required")
        @Positive(message = "Vacation days must be positive")
        Integer vacationDays,

        @FutureOrPresent
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate startVacation
) {
}