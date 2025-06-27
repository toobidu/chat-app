package org.example.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserContactId implements Serializable {
    @Column(name = "owner_id")
    private UUID ownerId;

    @Column(name = "contact_id")
    private UUID contactId;
}