package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.form.CredentialsForm;
import com.udacity.jwdnd.course1.cloudstorage.form.NotesForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;

import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/home")
public class HomeController {

    private NotesService notesService;
    private CredentialsService credentialsService;
    private UserService userService;
    String currentUserName;

    public HomeController(NotesService notesService, CredentialsService credentialsService, UserService userService){
        this.notesService = notesService;
        this.credentialsService = credentialsService;
        this.userService = userService;
    }

    @GetMapping
    public String getHome(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        User currentUser = this.userService.getUser(currentUserName);
        model.addAttribute("note", new Note());
        model.addAttribute("credential", new Credential());
        model.addAttribute("notes", this.notesService.getNotes());
        model.addAttribute("credentials", this.credentialsService.getCredentials());
        return "home";
    }

}
