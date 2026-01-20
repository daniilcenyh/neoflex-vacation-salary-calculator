package com.hamming.calculate_vacation_salary.service.impl;

import com.hamming.calculate_vacation_salary.entity.Holiday;
import com.hamming.calculate_vacation_salary.repository.HolidayRepository;
import com.hamming.calculate_vacation_salary.service.HolidayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HolidayServiceImpl implements HolidayService {

    private final HolidayRepository holidayRepository;

    @Override
    public boolean isHoliday(LocalDate date) {
        return this.holidayRepository.findByDate(date).isPresent();
    }

    @Override
    public List<Holiday> getHolidaysBetween(LocalDate startDate, LocalDate endDate) {
        return this.holidayRepository.findHolidaysBetweenDates(startDate, endDate);
    }

    @Override
    public int countHolidaysBetween(LocalDate startDate, LocalDate endDate) {
        return getHolidaysBetween(startDate, endDate).size();
    }

    public int calculatePaidVacationDays(LocalDate startDate, int calendarDays) {
        int paidDays = 0;
        LocalDate currentDate = startDate;
        int daysProcessed = 0;

        while (daysProcessed < calendarDays) {
            if (!isHoliday(currentDate)) {
                paidDays++;
            }
            currentDate = currentDate.plusDays(1);
            daysProcessed++;
        }

        log.debug("For vacation starting {} for {} days, paid days: {}",
                startDate, calendarDays, paidDays);
        return paidDays;
    }


}
