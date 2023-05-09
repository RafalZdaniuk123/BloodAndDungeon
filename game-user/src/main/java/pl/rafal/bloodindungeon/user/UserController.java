package pl.rafal.bloodindungeon.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.rafal.bloodindungeon.user.exception.ServiceLayerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    String saveUser(@RequestParam String surname, @RequestParam String email, @RequestParam String characterClass, Model model) {
        try {
            if (Objects.equals(characterClass, "0")) {
                model.addAttribute("users", userService.getAllUsers());
                model.addAttribute("success", "You need choose one of existing character class");
                return "allUsers";
            }
            userService.saveUser(surname, characterClass, null, email);
            model.addAttribute("success", "User added successfully");
            log.info("User " + surname + " added succesfully");
        } catch (ServiceLayerException ex) {
            model.addAttribute("success", "User adding failed");
            log.error("User " + surname + " adding failed");
        }
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping("/getAll")
    String getAllUsers(Model model) {
        System.out.println("Hello");
        model.addAttribute("users", userService.getAllUsers());
        System.out.println(userService.getAllUsers());
        return "allUsers";
    }

    @PostMapping("/delete")
    String deleteUser(Model model, @RequestParam("userId") int userId) {
        boolean isDeleted = userService.deleteUser(userId);
        System.out.println("Hello 2 ");
        if (isDeleted) {

            model.addAttribute("successDeletion",
                    "User deletion success");
            log.info("User " + userId + " deleted succesfully");
        } else {
            model.addAttribute("successDeletion",
                    "User deletion failed");
            log.info("User " + userId + " deletion failed");
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
    @GetMapping("/registration")
    String registrationForm(Model model) {
        List<Enum<CharacterClass>> classNames = new ArrayList(List.of(CharacterClass.values()));
        model.addAttribute("classNames", classNames);
        return "registrationForm";
    }

    //    @PostMapping("/registration")
//    String registerUser(Model model, @RequestBody RegistrationUser registrationUser) throws ServiceLayerException {
//        System.out.println(registrationUser);
//        userService.saveUser(registrationUser.getUsername(),
//                registrationUser.getCharacterClass().toString(),
//                registrationUser.getPassword());
//        model.addAttribute("users", userService.getAllUsers());
//        return "allUsers";
//    }
// Check how can I use Model in Request    @RequestModel
    @PostMapping("/registration")
    String registerUser(Model model,
                        @RequestParam String email,
                        @RequestParam String username,
                        @RequestParam String characterClass,
                        @RequestParam String password) throws ServiceLayerException {
        userService.saveUser(username,
                characterClass,
                password,
                email);
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }
}
