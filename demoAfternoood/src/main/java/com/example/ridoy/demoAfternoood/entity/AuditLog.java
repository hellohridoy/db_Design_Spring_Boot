package com.example.ridoy.demoAfternoood.entity;

import com.example.ridoy.demoAfternoood.enums.Operations;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "audit_log")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)  // Store enum as a string in the database
    private Operations operation; // e.g., "ADD_MEAL_COST", "UPDATE_BALANCE"

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String description; // Details about the operation

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
