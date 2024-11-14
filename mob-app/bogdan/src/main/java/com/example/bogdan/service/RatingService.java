package com.example.bogdan.service;

import com.example.bogdan.entity.Rating;
import com.example.bogdan.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getAllRatings() {
        List<Rating> ratings = new ArrayList<>();
        ratingRepository.findAll().forEach(ratings::add);
        return ratings;
    }

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }
}
