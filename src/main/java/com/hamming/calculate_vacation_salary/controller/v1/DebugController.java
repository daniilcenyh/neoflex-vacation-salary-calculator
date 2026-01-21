package com.hamming.calculate_vacation_salary.controller.v1;

import com.hamming.calculate_vacation_salary.entity.Holiday;
import com.hamming.calculate_vacation_salary.repository.HolidayRepository;
import com.hamming.calculate_vacation_salary.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/debug")
@RequiredArgsConstructor
public class DebugController {

    private final HolidayRepository holidayRepository;
    private final HolidayService holidayService;

    @GetMapping("/check-holiday/{date}")
    public String checkHoliday(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        boolean isHoliday = holidayService.isHoliday(localDate);
        Optional<Holiday> holiday = holidayRepository.findByDate(localDate);

        return String.format("""
            Date: %s
            isHoliday(): %s
            In DB: %s
            All holidays count: %d
            """,
                date, isHoliday, holiday.orElse(null),
                holidayRepository.count()
        );
    }

    @GetMapping("/holidays")
    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }
}