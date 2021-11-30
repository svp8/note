package com.vlad.note.repos;

import com.vlad.note.domain.Note;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NoteRepo extends CrudRepository<Note, Integer> {
    @Query("select header,text,date,note_id from Note n where n.user_id=:userid")
    public Iterable<Note> findByUser(@Param("userid")String user);
}
