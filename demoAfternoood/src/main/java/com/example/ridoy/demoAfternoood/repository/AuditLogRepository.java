package com.example.ridoy.demoAfternoood.repository;

import com.example.ridoy.demoAfternoood.entity.AuditLog;
import com.example.ridoy.demoAfternoood.enums.Operations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByPersonId(Long personId);
    List<AuditLog> findByOperation(Operations operation);
}
