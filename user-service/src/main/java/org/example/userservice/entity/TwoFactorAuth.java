package org.example.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "two_factor_auth")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TwoFactorAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "method_provider")
    private String methodProvider; // SMS, EMAIL, TOTP,...

    @Column(name = "secret")
    private String secret;

    @Column(name = "backup_code")
    private String backupCode;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "last_used_at")
    private LocalDateTime lastUsedAt;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
