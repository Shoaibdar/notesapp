package com.notes.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notes.model.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long> {

	 List<Notes> findByTitleContainingOrContentContaining(String title, String content);
}
