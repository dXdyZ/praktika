package com.example.bogdan.repository;

import com.example.bogdan.entity.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
}
