package com.example.ridoy.demoAfternoood.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class BalanceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}

