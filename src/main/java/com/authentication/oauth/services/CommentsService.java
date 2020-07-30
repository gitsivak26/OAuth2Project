package com.authentication.oauth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.oauth.model.UserComments;
import com.authentication.oauth.repository.CommentsDAO;

@Service
public class CommentsService {
	
	@Autowired
	CommentsDAO commentsDAO;
	
	public void addComments(UserComments userComments) {
		commentsDAO.save(userComments);
	}
	
	public void deleteComment(int id) {
		commentsDAO.deleteById(id);
	}
	
	public void listComment(int id) {
		commentsDAO.findById(id);
	}
	
	public List<UserComments> listAllComments() {
		 return commentsDAO.findAll();
	}
}
