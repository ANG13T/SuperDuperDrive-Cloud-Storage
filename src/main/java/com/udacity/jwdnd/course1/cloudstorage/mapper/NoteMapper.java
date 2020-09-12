package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES")
    List<Note> getNotes();

    @Select("SELECT * FROM NOTES WHERE ID = #{id}")
    Note getNote(Long id);

    @Update("UPDATE NOTES SET TITLE = #{title}, DESCRIPTION = #{description} WHERE ID=#{id}")
    void update(Note note);

    @Insert("INSERT INTO NOTES (title, description, userid) VALUES(#{title}, #{description}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insert(Note note);

    @Delete("DELETE FROM NOTES WHERE id = #{id}")
    void delete(Long id);
}
