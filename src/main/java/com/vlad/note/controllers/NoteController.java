package com.vlad.note.controllers;


import com.vlad.note.domain.Note;
import com.vlad.note.repos.NoteRepo;
import com.vlad.note.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteRepo noteRepo;
    @Autowired
    private NoteService service;


    @GetMapping(path="/note/all/{id}")
    public Iterable<Note> getAllNotes(@PathVariable String id) {
        // This returns a JSON or XML with the all notes
        Iterable<Note> notes=noteRepo.findAll();
        Iterator<Note> itr=notes.iterator();
        while (itr.hasNext()){
            if(!itr.next().getUser_id().equals(id)){
                itr.remove();
            }
        }

        return notes;

    }
//    @GetMapping(path="/note/all/{id}")
//    public Iterable<Note> getAllUserNotes(@PathVariable String id) {
//        // This returns a JSON or XML with the all notes
//        Iterable<Note> notes=noteRepo.findByUser(id);
//        return notes;
//    }
    @PostMapping(path="/note/save")
    public Note addNote(@RequestBody Note note){
        return service.saveNote(note);
    }
    @GetMapping(path="/note/get/{id}")
    public Note findNoteById(@PathVariable int id) {
        //
        return service.getNoteById(id);
    }
    @PutMapping(path="/note/update")
    public Note updateNote(@RequestBody Note note) {
        //
        return service.updateNote(note);
    }
    @DeleteMapping(path="/note/delete/{id}")
    public String deleteNote(@PathVariable String id) {
        //
        return service.deleteNote(Integer.parseInt(id));
    }

}
