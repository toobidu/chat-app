package org.example.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "block_users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlockUser {
    @EmbeddedId
    private BlockUserId id;

    @Column(name = "reason")
    private String reason;

    @Column(name = "is_block")
    private Boolean isBlock = true;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt; // Block tạm thời? Hết hạn lúc nào?

    @Column(name = "unblocked_at")
    private LocalDateTime unblockedAt; // Thời điểm unblock

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
