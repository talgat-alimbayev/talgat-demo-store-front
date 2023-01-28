package talgat.demo.store.front.controllers;

import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import talgat.demo.store.front.config.RegistrationForm;
import talgat.demo.store.front.services.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute(name = "registrationForm")
    public RegistrationForm addRegistrationFormToMode(Model model) {
        return new RegistrationForm();
    }

    @GetMapping
    public String registerForm(){
        return "registration";
    }

    @PostMapping
    public String processForm(@Valid RegistrationForm form, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()){
            return "registration";
        }
        userService.saveUser(form.toUser(passwordEncoder));
        sessionStatus.setComplete();
        return "redirect:/login";
    }

}
