package com.phumlanidev.notificationservice.controller;

import com.phumlanidev.notificationservice.dto.OrderNotificationDto;
import com.phumlanidev.notificationservice.service.impl.NotificationServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

  private final NotificationServiceImpl notificationService;

  @PostMapping("/email")
  public ResponseEntity<Void> sendOrderNotification(@Valid @RequestBody OrderNotificationDto dto) {
    notificationService.sendOrderNotification(dto);
    return ResponseEntity.ok().build();
  }

}
