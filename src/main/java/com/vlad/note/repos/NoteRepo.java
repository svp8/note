package com.vlad.note.repos;

import com.vlad.note.domain.Note;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NoteRepo extends CrudRepository<Note, Integer> {

}
