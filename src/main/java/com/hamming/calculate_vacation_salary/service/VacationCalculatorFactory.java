package com.hamming.calculate_vacation_salary.service;

import com.hamming.calculate_vacation_salary.service.impl.AdvancedVacationCalculatorService;
import com.hamming.calculate_vacation_salary.service.impl.HolidayServiceImpl;
import com.hamming.calculate_vacation_salary.service.impl.SimpleVacationCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VacationCalculatorFactory {

    private final HolidayServiceImpl holidayService;

    public CalculateVacationSalaryService getVacationSalaryCalculator(LocalDate startDate) {
        if (startDate == null) {
            return new SimpleVacationCalculatorService();
        }
        return new AdvancedVacationCalculatorService(this.holidayService);
    }
}
