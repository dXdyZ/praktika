package com.example.suit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @GetMapping("/report")
    public String showReport(Model model) {
        // Добавление пути к изображениям для отображения в HTML
        model.addAttribute("result1", "/images/result1.png");
        model.addAttribute("result2", "/images/result2.png");
        model.addAttribute("result3", "/images/result3.png");
        model.addAttribute("result4", "/images/result4.png");
        model.addAttribute("result5", "/images/result5.png");
        model.addAttribute("result6", "/images/result6.png");
        model.addAttribute("result7", "/images/result7.png");
        model.addAttribute("result8", "/images/result8.png");
        model.addAttribute("result9", "/images/result9.png");
        
        return "report"; // Возвращает шаблон HTML с именем report.html
    }
}
