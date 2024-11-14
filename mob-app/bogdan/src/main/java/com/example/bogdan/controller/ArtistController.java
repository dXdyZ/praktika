package com.example.bogdan.controller;

import com.example.bogdan.entity.Artist;
import com.example.bogdan.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public String getAllArtists(Model model) {
        model.addAttribute("artists", artistService.getAllArtists());
        return "artists";
    }

    @PostMapping
    public String saveArtist(@ModelAttribute Artist artist) {
        artistService.saveArtist(artist);
        return "redirect:/artists";
    }

    @GetMapping("/delete/{id}")
    public String deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return "redirect:/artists";
    }
}
