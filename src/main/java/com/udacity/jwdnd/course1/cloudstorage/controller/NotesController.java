package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/notes")
public class NotesController {

    UserService userService;
    NotesService notesService;
    String currentUserName;

    public NotesController(UserService userService, NotesService notesService){
        this.userService = userService;
        this.notesService = notesService;
    }

    @PostMapping
    public RedirectView postNote(Model model, @ModelAttribute("note") Note note){
        System.out.println("creating note....");
        System.out.println(note.getTitle() + "," + note.getDescription());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        User currentUser = this.userService.getUser(currentUserName);
        note.setUserid(currentUser.getUserId());
        notesService.setNote(note);
        return new RedirectView("home");
    }
}
