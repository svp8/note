package com.vlad.note.repos;

import com.vlad.note.domain.Note;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepo extends CrudRepository<Note, Integer> {
}
