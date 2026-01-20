package com.hamming.calculate_vacation_salary.service;

import com.hamming.calculate_vacation_salary.entity.Holiday;

import java.time.LocalDate;
import java.util.List;

public interface HolidayService {
    boolean isHoliday(LocalDate date);
    List<Holiday> getHolidaysBetween(LocalDate startDate, LocalDate endDate);
    int countHolidaysBetween(LocalDate startDate, LocalDate endDate);
}
