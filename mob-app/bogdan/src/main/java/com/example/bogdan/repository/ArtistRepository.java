package com.example.bogdan.repository;

import com.example.bogdan.entity.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
