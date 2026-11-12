package com.claimguard.claimguard.user;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullName;

    // Users log in with email (this becomes the "username" for Spring Security)
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    // Will store a BCrypt HASH (never plain text). BCrypt hashes are 60 chars.
    @Column(nullable = false, length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Role role;

    // Which health plan (client) this user belongs to - used for tenant isolation on Day 10
    @Column(nullable = false, length = 50)
    private String clientId;

    // Admin can disable an account without deleting it
    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
