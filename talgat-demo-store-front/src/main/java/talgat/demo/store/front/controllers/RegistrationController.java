package talgat.demo.store.front.controllers;

//import org.springframework.security.crypto.password.PasswordEncoder;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import talgat.demo.store.front.config.RegistrationForm;
import talgat.demo.store.front.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping
    public String registerForm(){
        return "registration";
    }

    @PostMapping
    public String processForm(RegistrationForm form){
        System.out.println(form.toString());
        System.out.println(passwordEncoder.encode(form.getPassword()).toString().length());
        userRepo.save(form.toUser(passwordEncoder)).subscribe();
        return "redirect:/login";
    }

//    @PostMapping
//    public String processForm(RegistrationForm form){
//        System.out.println(form.toString());
//        userRepo.save(form.toUser()).subscribe();
//        return "redirect:/login";
//    }
}
