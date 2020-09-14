package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private FileMapper fileMapper;
    private UserMapper userMapper;

    public FileService(FileMapper fileMapper, UserMapper userMapper){
        this.fileMapper = fileMapper;
        this.userMapper = userMapper;
    }

    public void setFile(File file){
        fileMapper.insert(file);
    }

    public List<File> getFiles(Integer userid){
        return fileMapper.getFiles(userid);
    }

    public File getFile(Long id){
        return fileMapper.getFile(id);
    }

    public File getByName(String fileName){ return fileMapper.getByName(fileName); }

    public void deleteFile(Long id){
        fileMapper.delete(id);
    }

}
