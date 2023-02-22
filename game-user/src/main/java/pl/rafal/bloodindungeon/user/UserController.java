package pl.rafal.bloodindungeon.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.rafal.bloodindungeon.user.exception.ServiceLayerException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/add")
    String saveUserPage(Model model) {

        List<Enum<CharacterClass>> classNames = new ArrayList(List.of(CharacterClass.values()));
        model.addAttribute("classNames", classNames);
        return "saveForm";
    }

    @PostMapping("/add")
    String saveUser(@RequestParam String surname, @RequestParam String characterClass, Model model) {
        try {
            userService.saveUser(surname, characterClass);
            model.addAttribute("success", "User added successfully");
            log.info("User " + surname + " added succesfully");
        } catch (ServiceLayerException ex) {
            model.addAttribute("success", "User adding failed");
            log.error("User " + surname + " adding failed");
        }
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/user/getAll";
    }

    @GetMapping("/getAll")
    String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        System.out.println(userService.getAllUsers());
        return "allUsers";
    }

    @PostMapping("/delete")
    String deleteUser(Model model, @RequestParam("userId") int userId) {
        boolean isDeleted = userService.deleteUser(userId);
        if (isDeleted) {
            model.addAttribute("successDeletion",
                    "User deletion success");
        } else {
            model.addAttribute("successDeletion",
                    "User deletion failed");
        }


        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

//    @PostMapping("/update")
//    String updateUser(Model model, UUID userId, User user){
//        userService.saveUser(user);
//        model.addAttribute("users", userService.getAllUsers());
//        return "allUsers";
//    }

//    @PostMapping("/registration")
//    String registerUser(Model model, RegistrationUser registrationUser){
//        userService.registerUser(registrationUser);
//        model.addAttribute("users", userService.getAllUsers());
//        return "allUsers";
//    }
}
