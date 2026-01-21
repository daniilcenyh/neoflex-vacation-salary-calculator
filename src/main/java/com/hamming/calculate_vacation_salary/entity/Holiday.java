package com.hamming.calculate_vacation_salary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "holidays")
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false, unique = true)
    private LocalDate date;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_day_off")
    private Boolean isDayOff;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}