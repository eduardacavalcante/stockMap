package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yahoofinance.Stock;

import java.util.List;


@Controller
public class UserController {

    //TODO: Avoid instantiate repository class in controller layer, create a service layer for that (userService)
    @Autowired(required = true)
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setFirstName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping("/welcome")
    public String getWelcome(Model model){
        model.addAttribute("message", "working");
        return "welcome";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("user", new User()); //adicionando a classe User na sessao para passar pro HTML
        //arquivo register.html como sao tratado os campos da classe User, th:object="${user}"
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(User user) {
        //TODO: Implement Validations before: if Fields are null or empty, if user already exists, etc...
        userService.save(user);
        //TODO: Implement error treatment after save, what happens if the save process fails?
        return "success";
    }

    @GetMapping("/mywallet")
    public String getWallet(Model model) throws Exception {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(obj instanceof UserDetails){
            String email = ((UserDetails) obj).getUsername();
            User user = userService.findByEmail(email);
            model.addAttribute("user", user);
        }
        return "mywallet";
    }


}
