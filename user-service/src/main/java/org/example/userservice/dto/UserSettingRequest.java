package org.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSettingRequest {
    private UUID userId;
    private Boolean notificationsOn;
    private String theme;
    private String language;
    private Boolean autoDownloadMedia;
    private String privacyMode;
}