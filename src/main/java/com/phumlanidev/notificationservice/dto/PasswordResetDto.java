package com.phumlanidev.notificationservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordResetDto {

  @NotBlank(message = "Email is required")
  private String email;
}