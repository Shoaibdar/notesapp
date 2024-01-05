package com.notes.services;

import java.util.List;
import java.util.Optional;


import com.notes.model.Notes;


public interface NotesService {
	
	List<Notes> getNotes();
	
	Notes createNotes(Notes notes);
	
	Optional<Notes> getNoteById(long id);
	
	//String updateNotes(long id);
	
	List<Notes> searchNotes(String q);

	String deleteNote(long id);

	String updateNote(Long id, Notes notes);


	


	

}
