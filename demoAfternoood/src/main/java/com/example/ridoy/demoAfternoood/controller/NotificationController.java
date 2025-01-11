package com.example.ridoy.demoAfternoood.controller;

import com.example.ridoy.demoAfternoood.entity.Notification;
import com.example.ridoy.demoAfternoood.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/api/v1/afternoon-delights/notification-infos/person/{personId}")
    public List<Notification> getNotificationsByPerson(@PathVariable Long personId) {
        return notificationService.getNotificationsByPersonId(personId);
    }

    @PostMapping("/api/v1/afternoon-delights/notification-infos")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }
}

