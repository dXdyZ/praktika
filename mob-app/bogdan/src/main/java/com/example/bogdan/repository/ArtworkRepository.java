package com.example.bogdan.repository;

import com.example.bogdan.entity.Artwork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends CrudRepository<Artwork, Long> {
}
