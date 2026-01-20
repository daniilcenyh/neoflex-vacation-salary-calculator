package com.hamming.calculate_vacation_salary.dto.response;

import java.math.BigDecimal;

public record VacationCalculateResponse(
        BigDecimal vacationPay
) {
}
