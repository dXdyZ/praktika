package com.example.libray;

@Controller
public class LibraryController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookUserService bookUserService;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String phoneNumber, Model model) {
        try {
            Users user = userService.authenticateUser(username, phoneNumber);
            model.addAttribute("user", user);
            model.addAttribute("books", bookService.getAllBook());
            return "main";
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка авторизации: " + e.getMessage());
            return "login";
        }
    }

    @PostMapping("/reserve")
    public String reserveBook(@RequestParam String bookName, @RequestParam String author,
                              @RequestParam String receiverDate, @RequestParam String recoilDate,
                              @RequestParam String username, @RequestParam String phoneNumber,
                              Model model) {
        ReceiverDTO receiverDTO = ReceiverDTO.builder()
                .username(username)
                .phoneNumber(phoneNumber)
                .bookName(bookName)
                .author(author)
                .receiverDate(receiverDate)
                .recoilDate(recoilDate)
                .build();
        String result = bookUserService.receiverBook(receiverDTO);
        model.addAttribute("result", result);
        model.addAttribute("books", bookService.getAllBook());
        return "main";
    }
}
