package com.learning.journal.services;

import com.learning.journal.entities.Journal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JournalService {
    private Map<Long, Journal> journals = new HashMap<>();

    public List<Journal> getAll(){
        return new ArrayList<> (journals.values());
    }

    public Journal createJournal(Journal newJournal){
        journals.put(newJournal.getId(), newJournal);
        return newJournal;
    }

    public Journal updateJournal(Long id, Journal newJournal){
        journals.replace(id, newJournal);
        return newJournal;
    }

    public Boolean deleteJournal(Long id){
        journals.remove(id);
        return true;
    }
}
