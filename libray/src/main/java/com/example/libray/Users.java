package com.example.libray;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String phoneNumber;
    private String password;
    private String role;

    public boolean isAdmin() {
        return "ADMIN".equalsIgnoreCase(role);
    }
}
