package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private final UserService userService;

    public SignUpController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String getSignUp(){
        return "signup";
    }

    @PostMapping
    public String signupUser(@ModelAttribute User user, Model model) {
       boolean signUpError = false;
       String errorMessage = "Something went wrong. Please try again.";

       if(!userService.isUsernameAvailable(user.getUsername())){
           System.out.println("The username already exsists");
           signUpError = true;
           errorMessage = "The username already exsists";
       }

       if(signUpError == false){
           int rowsAdded = userService.createUser(user);
           if(rowsAdded < 0){
               signUpError = true;
           }
       }

        if(signUpError == false){
            model.addAttribute("signupSuccess", true);
            return "redirect:/login";
        }else{
            System.out.println("There are some errors");
            model.addAttribute("signupSuccess", false);
            model.addAttribute("signupError", true);
            model.addAttribute("errorMessage", errorMessage);
        }

       return "signup";
    }
}
