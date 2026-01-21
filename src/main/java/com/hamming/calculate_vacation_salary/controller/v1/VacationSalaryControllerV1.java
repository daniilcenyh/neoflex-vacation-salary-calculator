package com.hamming.calculate_vacation_salary.controller.v1;

import com.hamming.calculate_vacation_salary.dto.request.VacationCalculateRequest;
import com.hamming.calculate_vacation_salary.dto.response.VacationCalculateResponse;
import com.hamming.calculate_vacation_salary.service.VacationCalculatorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calculate")
public class VacationSalaryControllerV1 {

    private final VacationCalculatorFactory factory;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VacationCalculateResponse> calculate(
            @RequestBody @Validated VacationCalculateRequest request
    ) {
        var vacationSalaryCalculator = factory.getVacationSalaryCalculator(request.startVacation());
        var vacationSalary = vacationSalaryCalculator.calculate(request.averageSalary(),
                request.vacationDays(),
                request.startVacation());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new VacationCalculateResponse(vacationSalary));
    }
}