package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.form.NotesForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;

import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private NotesService notesService;
    private UserService userService;
    String currentUserName;

    public HomeController(NotesService notesService, UserService userService){
        this.notesService = notesService;
        this.userService = userService;
    }

    @GetMapping
    public String getHome(Model model){
        model.addAttribute("notesForm", new NotesForm());
        model.addAttribute("notes", this.notesService.getNotes());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
            System.out.println(currentUserName);
        }
        return "home";
    }

    @PostMapping
    public String postNote(@ModelAttribute("notesForm") NotesForm notesForm, Model model){
        User currentUser = this.userService.getUser(currentUserName);
        notesService.setNote(new Note(notesForm.getId(), notesForm.getTitle(), notesForm.getDescription(), currentUser.getUserId()));
        return "home";
    }
}
