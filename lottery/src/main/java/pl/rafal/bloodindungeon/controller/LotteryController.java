package pl.rafal.bloodindungeon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rafal.bloodindungeon.user.UserService;

@Controller
@RequestMapping("/lottery")
@RequiredArgsConstructor
public class LotteryController {

    private final UserService userService;

    @GetMapping
    public String lotterySpin(){
        return "spinPage";
    }

    @PostMapping("/spin")
    public String spin(Model model, Authentication authentication){
        double money = 10;
        model.addAttribute("treasure", money);
        userService.updateUserBalance(authentication.getName(), money);
        return "spin";
    }

}
