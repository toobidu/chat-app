package org.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSettingResponse {
    private Long id;
    private UUID userId;
    private Boolean notificationsOn;
    private String theme;
    private String language;
    private Boolean autoDownloadMedia;
    private String privacyMode;
}