package com.authentication.oauth.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.oauth.model.UserComments;
import com.authentication.oauth.services.CommentsService;

@RestController
public class CommentsController {

	@Autowired
	CommentsService commentsService;
	
	@PostMapping("/api/v1/comments")
	public ResponseEntity<?> addComment(@ModelAttribute UserComments userComments) {
		
		commentsService.addComments(userComments);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Comments has been successfully saved.");
	}
	
	@DeleteMapping("/api/v1/comments/delete/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable("id") int id) {
		
		commentsService.deleteComment(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Comments has been deleted successfully.");
	}
	
	@GetMapping("api/v1/comments/list/{id}")
	public ResponseEntity<?> listComment(@PathVariable("id") int id) {
		
		commentsService.listComment(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Comments has been selected successfully.");
	}
	
	@GetMapping("/api/v1/comments/list")
	public ResponseEntity<?> listAllComments() {
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(commentsService.listAllComments());
	}
}
