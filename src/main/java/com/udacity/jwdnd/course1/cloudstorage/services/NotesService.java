package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.form.NotesForm;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class NotesService {
    private NoteMapper noteMapper;
    private UserMapper userMapper;

    public NotesService(NoteMapper noteMapper, UserMapper userMapper){
        this.noteMapper = noteMapper;
        this.userMapper = userMapper;
    }

    public List<Note> getNotes(Integer userid) {
        return noteMapper.getNotes(userid);
    }

    public void setNote(Note n){
        if(noteMapper.getNote(n.getId()) != null){
            //update note
            System.out.println("updating note...");
            noteMapper.update(n);
        }else{
            //create note
            System.out.println("Creating note...");
            noteMapper.insert(n);
        }
    }

    public void deleteNote(Long id){
        noteMapper.delete(id);
    }

    public Note getNote(Long id){
        return noteMapper.getNote(id);
    }
}
