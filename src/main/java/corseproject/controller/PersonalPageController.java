package corseproject.controller;

import corseproject.domain.Role;
import corseproject.domain.TShirt;
import corseproject.domain.User;
import corseproject.repos.TShirtRepository;
import corseproject.repos.UserRepository;
import corseproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/{username}")
public class PersonalPageController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TShirtRepository tShirtRepository;
    @Autowired
    private UserService userService;

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${cloudinary.path}")
    private String cloudinaryPath;

    @GetMapping()
    public String personalPage(Model model,
                               @AuthenticationPrincipal User authUser,
                               @PathVariable String username){
        User user = userRepository.findByUsername(username);
        if(!userService.getAccess(authUser, username)){
            return "redirect:/";
        }

        List<TShirt> tShirts =  tShirtRepository.findByAuthor(user);
        model.addAttribute("tShirts", tShirts);
        model.addAttribute("user", authUser);
        model.addAttribute("userpage", user);
        return "mypage";
    }
}