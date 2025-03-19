package com.learning.journal.services;

import com.learning.journal.entities.Journal;
import com.learning.journal.repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    public ResponseEntity<?> getAll(){
        try {
            List<Journal> allJournal = journalRepository.findAll();
            if(!allJournal.isEmpty()){
                return new ResponseEntity<>(allJournal, HttpStatus.OK);
            } else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> createJournal(Journal newJournal){
        try {
            Journal existingJournal = journalRepository.findById(newJournal.getId()).orElse(null);
            if(existingJournal == null) {
                journalRepository.save(newJournal);
                return new ResponseEntity<>(newJournal, HttpStatus.CREATED);
            } else{
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updateJournal(Long id, Journal newJournal){
        try {
            Journal desireJournal = journalRepository.findById(id).orElse(null);
            if (desireJournal != null) {
                desireJournal.setTitle(newJournal.getTitle());
                desireJournal.setContent(newJournal.getContent());
                journalRepository.save(desireJournal);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> deleteJournal(Long id){
        try {
            journalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
