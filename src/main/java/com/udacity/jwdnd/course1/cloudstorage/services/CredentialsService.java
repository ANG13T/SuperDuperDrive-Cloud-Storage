package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.form.NotesForm;
import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class CredentialsService {
    private CredentialMapper credentialMapper;
    private UserMapper userMapper;
    private EncryptionService encryptionService;
    SecureRandom random = new SecureRandom();
    String encodedKey;
    byte[] key = new byte[16];


    public CredentialsService(CredentialMapper credentialMapper, UserMapper userMapper, EncryptionService encryptionService){
        this.credentialMapper = credentialMapper;
        random.nextBytes(key);
        encodedKey = Base64.getEncoder().encodeToString(key);
        this.userMapper = userMapper;
        this.encryptionService = encryptionService;
    }

    public List<Credential> getCredentials(Integer userId) {
        System.out.println("Getting credentials....");
        System.out.println(credentialMapper.getCredentials(userId));
        List<Credential> creds = credentialMapper.getCredentials(userId);
        if(!creds.isEmpty()){
            creds.forEach(credential -> {
                String decryptedPassword = encryptionService.decryptValue(credential.getPassword(), encodedKey);
                credential.setDecryptedPassword(decryptedPassword);
            });
        }
        return creds;
    }

    public void deleteCredential(Long id){
        credentialMapper.delete(id);
    }


    public void setCredential(Credential credential, Integer userId){
        System.out.println("setting credential");
        credential.setPassword(encryptionService.encryptValue(credential.getPassword(), encodedKey));
        System.out.println(credentialMapper.getCredential(credential.getCredentialid(), userId));
        if(credentialMapper.getCredential(credential.getCredentialid(), userId) != null){
            //update cred
            System.out.println("updating note");
            credentialMapper.update(credential);
        }else{
            //create cred
            System.out.println("creating note");
            credentialMapper.insert(credential);
        }
    }
}
