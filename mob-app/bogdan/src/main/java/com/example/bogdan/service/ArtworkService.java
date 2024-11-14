package com.example.bogdan.service;

import com.example.bogdan.entity.Artwork;
import com.example.bogdan.repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtworkService {
    @Autowired
    private ArtworkRepository artworkRepository;

    public List<Artwork> getAllArtworks() {
        List<Artwork> artworks = new ArrayList<>();
        artworkRepository.findAll().forEach(artworks::add);
        return artworks;
    }

    public Artwork saveArtwork(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    public Artwork getArtworkById(Long id) {
        return artworkRepository.findById(id).orElse(null);
    }

    public void deleteArtwork(Long id) {
        artworkRepository.deleteById(id);
    }
}
