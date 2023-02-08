package pl.rafal.bloodindungeon.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/add")
    String saveUserPage(){
        return "saveForm";
    }
    @PostMapping("/add")
    String saveUser(User user, Model model){
        userService.saveUser(user);
        model.addAttribute("success", "User added successfully");
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping("/getAll")
    String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        System.out.println(userService.getAllUsers());
        return "allUsers";
    }

    @PostMapping("/delete")
    String deleteUser(Model model, int userId){
        userService.deleteUser(userId);
        model.addAttribute("successDeletion", "Delete user successfully");
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

    @PostMapping("/update")
    String updateUser(Model model, UUID userId, User user){
        userService.saveUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }
//
//    @PostMapping("/registration")
//    String registerUser(Model model, RegistrationUser registrationUser){
//        userService.registerUser(registrationUser);
//        model.addAttribute("users", userService.getAllUsers());
//        return "allUsers";
//    }
}
