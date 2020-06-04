package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/course")
    public String course() {
        return "course";
    }

    @RequestMapping("/teacher")
    public String teacher() {
        return "teacher";
    }

    @RequestMapping("/student")
    public String student() {
        return "student";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    // to see two different options of getted the logged user.
    // This method doesnot require having Principal in model.
    // It works by function call.
    @RequestMapping("/secure")
        public String secure(Principal principal, Model model) {
            String username = principal.getName();
            model.addAttribute("user", userRepository.findByUsername(username));
//        if(userService.getUser() != null) {
//            model.addAttribute("user_id", userService.getUser().getId());
//        }
            return "secure";
        }

//    @RequestMapping("/secure2")
//    public String openSecurePage(Model model){
//    if(userService.getUser() != null) {
//        model.addAttribute("user_id", userService.getUser().getId());
//    }
//    return "secure";
//    }


    @PostMapping("/logout")
    public String logout() {
        return "redirect:/login?logout=true";
    }

}
