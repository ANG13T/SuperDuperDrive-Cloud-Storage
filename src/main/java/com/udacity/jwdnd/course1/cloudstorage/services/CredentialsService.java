package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.form.NotesForm;
import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialsService {
    private CredentialMapper credentialMapper;
    private UserMapper userMapper;

    public CredentialsService(CredentialMapper credentialMapper, UserMapper userMapper){
        this.credentialMapper = credentialMapper;
        this.userMapper = userMapper;
    }

    public List<Credential> getCredentials() {
        System.out.println("Getting credentials....");
        System.out.println(credentialMapper.getCredentials());
        return credentialMapper.getCredentials();
    }

    public void deleteCredential(Long id){
        credentialMapper.delete(id);
    }

    public void updateCredential(Credential credential){
        credentialMapper.update(credential);
    }

    public void setCredential(Credential credential){
        credentialMapper.insert(credential);
    }
}
