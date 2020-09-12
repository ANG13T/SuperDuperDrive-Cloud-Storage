package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/credentials")
public class CredentialsController {

    UserService userService;
    CredentialsService credentialsService;
    String currentUserName;

    public CredentialsController(UserService userService, CredentialsService credentialsService){
        this.userService = userService;
        this.credentialsService = credentialsService;
    }



    @PostMapping
    public RedirectView postCredentials(@ModelAttribute("credential") Credential credential, Model model){
        System.out.println("creating credential...");
        System.out.println(credential.getUsername());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        User currentUser = this.userService.getUser(currentUserName);
        credential.setUserid(currentUser.getUserId());
        this.credentialsService.setCredential(credential);
        return new RedirectView("home");
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public String handleDeleteCredential(@PathVariable String id) {
        System.out.println(id);
        System.out.println("deleting credential");
        this.credentialsService.deleteCredential(Long.parseLong(id));
        System.out.println("deleted credential");
        return "redirect:/home";
    }

}
