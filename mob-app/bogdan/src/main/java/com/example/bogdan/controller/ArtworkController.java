package com.example.bogdan.controller;

import com.example.bogdan.entity.Artwork;
import com.example.bogdan.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artworks")
public class ArtworkController {
    @Autowired
    private ArtworkService artworkService;

    @GetMapping
    public String getAllArtworks(Model model) {
        model.addAttribute("artworks", artworkService.getAllArtworks());
        return "artworks";
    }

    @PostMapping
    public String saveArtwork(@ModelAttribute Artwork artwork) {
        artworkService.saveArtwork(artwork);
        return "redirect:/artworks";
    }

    @GetMapping("/delete/{id}")
    public String deleteArtwork(@PathVariable Long id) {
        artworkService.deleteArtwork(id);
        return "redirect:/artworks";
    }
}
