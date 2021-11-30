package com.vlad.note.services;

import com.vlad.note.domain.Note;
import com.vlad.note.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;

    public Note saveNote(Note note){
        note.setDate(LocalDateTime.now());
        return noteRepo.save(note);
    }
    public Note getNoteById(int id){
        return noteRepo.findById(id).orElse(null);
    }
    public String deleteNote(int id){
        Note note=noteRepo.findById(id).orElse(null);
        if(note!=null){
            noteRepo.deleteById(id);
            return "deleted "+id;
        }
        else {
            throw new RuntimeException("Wrong id");
        }
    }
    public Note updateNote(Note note){
        Note oldNote=noteRepo.findById(note.getNote_id()).orElse(null);
        oldNote.setHeader(note.getHeader());
        oldNote.setText(note.getText());
        oldNote.setDate(LocalDateTime.now());
        return noteRepo.save(oldNote);
    }

}
