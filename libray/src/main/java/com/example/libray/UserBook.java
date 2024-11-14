package com.example.libray;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date reservationDate;
    private Date recoilDate;

    @OneToOne
    private Users users;

    @OneToOne
    private Book books;
}
