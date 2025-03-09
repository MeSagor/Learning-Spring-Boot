package com.learning.journal.controllers;

import com.learning.journal.entities.Journal;
import com.learning.journal.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @GetMapping("/all")
    public List<Journal> getAll(){
        return journalService.getAll();
    }

    @PostMapping("/create")
    public Journal createJournal(@RequestBody Journal newJournal){
        return journalService.createJournal(newJournal);
    }

    @PutMapping("/id/{id}")
    public Journal updateJournal(@PathVariable Long id, @RequestBody Journal newJournal){
        return journalService.updateJournal(id, newJournal);
    }

    @DeleteMapping("/id/{id}")
    public Boolean deleteJournal(@PathVariable Long id){
        return journalService.deleteJournal(id);
    }
}
