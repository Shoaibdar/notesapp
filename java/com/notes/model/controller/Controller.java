package com.notes.model.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notes.model.Notes;
import com.notes.services.NotesService;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	NotesService notesService;

	@GetMapping("/public")
	public String getNotess() {
		return "public endpont";
	}
	
	@GetMapping("/notes")
	public ResponseEntity<List<Notes>> getNotes() {
		try {
			List<Notes> notes = notesService.getNotes();
			return ResponseEntity.ok(notes);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping("/notes")
	public ResponseEntity<Notes> createNote(@RequestBody Notes notes) {
		try {
			Notes createdNote = notesService.createNotes(notes);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/notes/{id}")
	public ResponseEntity<Notes> getNoteById(@PathVariable long id) {
		try {
			Optional<Notes> note = notesService.getNoteById(id);
			return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PutMapping("/notes/{id}")
	public ResponseEntity<String> updateNoteById(@PathVariable long id, @RequestBody Notes notes) {
		try {
			String result = notesService.updateNote(id, notes);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating note");
		}
	}

	@DeleteMapping("/notes/{id}")
	public ResponseEntity<String> deleteNoteById(@PathVariable long id) {
		try {
			String result = notesService.deleteNote(id);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting note");
		}
	}


	@GetMapping("/search")
	public ResponseEntity<List<Notes>> searchNotes(@RequestParam String q) {
		try {
			List<Notes> searchResults = notesService.searchNotes(q);
			return ResponseEntity.ok(searchResults);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
