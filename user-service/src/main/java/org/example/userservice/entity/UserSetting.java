package org.example.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_settings")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private UUID userId; // Không dùng @OneToOne

    @Column(name = "notifications_on")
    private Boolean notificationsOn;

    @Column(name = "theme")
    private String theme;

    @Column(name = "language")
    private String language;

    @Column(name = "auto_download_media")
    private Boolean autoDownloadMedia;

    @Column(name = "privacy_mode")
    private String privacyMode;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}