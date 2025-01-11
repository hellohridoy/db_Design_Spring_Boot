package com.example.ridoy.demoAfternoood.repository;

import com.example.ridoy.demoAfternoood.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByPersonId(Long personId);
}
