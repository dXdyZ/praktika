package com.example.libray;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String author;
    private Date date;

    public static Date mapStringInDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
