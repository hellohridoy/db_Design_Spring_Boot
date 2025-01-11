package com.example.ridoy.demoAfternoood.service;

import com.example.ridoy.demoAfternoood.entity.Notification;
import com.example.ridoy.demoAfternoood.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getNotificationsByPersonId(Long personId) {
        return notificationRepository.findByPersonId(personId);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
}

