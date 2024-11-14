package com.example.bogdan.controller;


import com.example.bogdan.entity.Users;
import com.example.bogdan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    private Users loggedInUser = null; // Переменная для хранения авторизованного пользователя

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        var userOptional = userService.getUserByUsername(username);

        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            loggedInUser = userOptional.get(); // Устанавливаем пользователя как авторизованного
            model.addAttribute("user", loggedInUser);
            return "redirect:/dashboard"; // Перенаправление на страницу после успешного входа
        } else {
            model.addAttribute("error", "Неверные данные");
            return "login"; // Возврат на страницу логина с ошибкой
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        if (loggedInUser == null) { // Проверка на наличие авторизованного пользователя
            return "redirect:/login"; // Перенаправление на логин, если пользователь не авторизован
        }
        model.addAttribute("user", loggedInUser);
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout() {
        loggedInUser = null; // Сброс авторизации
        return "redirect:/login";
    }
}


