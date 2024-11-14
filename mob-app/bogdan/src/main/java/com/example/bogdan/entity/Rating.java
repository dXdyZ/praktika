package com.example.bogdan.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "artwork_id", nullable = false)
    private Artwork artwork;

    @Column(nullable = false)
    private int rating;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and setters
}
