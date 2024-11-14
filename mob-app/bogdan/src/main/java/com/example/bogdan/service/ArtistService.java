package com.example.bogdan.service;

import com.example.bogdan.entity.Artist;
import com.example.bogdan.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        List<Artist> list = new ArrayList<>();
        artistRepository.findAll().forEach(list::add);
        return list;
    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}
