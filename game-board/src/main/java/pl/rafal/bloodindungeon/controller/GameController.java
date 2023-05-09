package pl.rafal.bloodindungeon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rafal.bloodindungeon.user.UserService;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final UserService userService;

    @GetMapping("/town")
    public String gameTown(Model model, Authentication authentication) {
        getPlayer(model, authentication);
        return "town";
    }

    @GetMapping("/user-stat")
    public String getUserStatistics(Model model, Authentication authentication) {
        getPlayer(model, authentication);
        return "userStats";
    }

    private Model getPlayer(Model model, Authentication authentication) {
        return model.addAttribute("player", userService.getUserByUsername(authentication.getName()));
    }
}
