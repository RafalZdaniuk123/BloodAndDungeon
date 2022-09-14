package pl.rafal.bloodindungeon.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    String saveUser(User user, Model model){
        userService.saveUser(user);
        model.addAttribute("success", "User added successfully");
        return "allUsers";
    }

    @GetMapping("/getAll")
    String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }
}
