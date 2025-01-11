package com.example.ridoy.demoAfternoood.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data

public class MonthlySummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalBalance;
    private LocalDate month;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}