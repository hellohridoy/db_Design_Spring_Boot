package com.example.ridoy.demoAfternoood.controller;

import com.example.ridoy.demoAfternoood.entity.AuditLog;
import com.example.ridoy.demoAfternoood.enums.Operations;
import com.example.ridoy.demoAfternoood.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuditLogController {

    private final AuditLogService auditLogService;

    @GetMapping("/api/v1/audit-log/person-infos/{personId}")
    public List<AuditLog> getLogsByPerson(@PathVariable Long personId) {
        return auditLogService.getLogsByPerson(personId);
    }

    @GetMapping("/api/v1/audit-log/person-infos/operation")
    public List<AuditLog> getLogsByOperation(@RequestParam Operations operation) {
        return auditLogService.getLogsByOperation(operation);
    }
}

