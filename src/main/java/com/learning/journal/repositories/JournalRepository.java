package com.learning.journal.repositories;

import com.learning.journal.entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JournalRepository extends JpaRepository<Journal, Long> {

}
