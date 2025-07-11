package com.phumlanidev.notificationservice.service.impl;

import com.phumlanidev.notificationservice.dto.AuditLogDto;
import com.phumlanidev.notificationservice.model.AuditLog;
import com.phumlanidev.notificationservice.repository.AuditLogRepository;
import com.phumlanidev.notificationservice.utils.AuditLogSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * Comment: this is the placeholder for documentation.
 */
@Service
@RequiredArgsConstructor
public class AuditLogServiceImpl {

  private final AuditLogRepository auditLogRepository;

  /**
   * Comment: this is the placeholder for documentation.
   */
  public void log(String action, String userId, String username, String ipAddress, String details) {
    AuditLog log = AuditLog.builder()
            .action(action)
            .userId(userId)
            .username(username)
            .ipAddress(ipAddress)
            .details(details)
            .timestamp(Instant.now())
            .build();

    auditLogRepository.save(log);
  }

  /**
   * Comment: this is the placeholder for documentation.
   */
  public Page<AuditLogDto> getAuditLogs(String userId, String action, Pageable pageable) {
    Specification<AuditLog> spec = AuditLogSpecifications.hasUserId(userId)
            .and(AuditLogSpecifications.hasAction(action));

    return auditLogRepository.findAll(spec, pageable).map(this::toDto);
  }

  private AuditLogDto toDto(AuditLog log) {
    return AuditLogDto.builder()
            .id(String.valueOf(log.getId()))
            .userId(log.getUserId())
            .username(log.getUsername())
            .action(log.getAction())
            .ip(log.getIpAddress())
            .details(log.getDetails())
            .timestamp(log.getTimestamp())
            .build();
  }
}