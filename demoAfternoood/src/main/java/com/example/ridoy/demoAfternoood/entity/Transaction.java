package com.example.ridoy.demoAfternoood.entity;

import com.example.ridoy.demoAfternoood.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type; // CREDIT or DEBIT

    @Column(name = "timestamp")
    private LocalDateTime transactionTime;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
