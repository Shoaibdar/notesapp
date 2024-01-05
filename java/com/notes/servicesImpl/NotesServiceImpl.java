package com.notes.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.notes.model.Notes;
import com.notes.model.repository.NotesRepository;
import com.notes.services.NotesService;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	NotesRepository notesRepository;

	@Override
	public List<Notes> getNotes() {
		return notesRepository.findAll();
	}

	@Override
	public Notes createNotes(Notes notes) {
		return notesRepository.save(notes);
	}

	@Override
	public Optional<Notes> getNoteById(long id) {
		return notesRepository.findById(id);
	}

	@Override
	public List<Notes> searchNotes(String q) {
	    return notesRepository.findByTitleContainingOrContentContaining(q, q);
	}


	@Override
	public String deleteNote(long id) {
		notesRepository.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	public String updateNote(Long id, Notes notes) {
		Notes existingNote;
		try {
			existingNote = notesRepository.findById(id).orElseThrow(() -> new NotFoundException());
			existingNote.setTitle(notes.getTitle());
			existingNote.setContent(notes.getContent());
			notesRepository.save(existingNote);
			return "Note Updated";
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Note Not Updated";
		

	}

	public void setNotesRepository(NotesRepository notesRepositoryMock) {
		// TODO Auto-generated method stub
		
	}

}
