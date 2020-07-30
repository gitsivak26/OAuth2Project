package com.authentication.oauth.controllers.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentsUIController {
	
	private static final String COMMENTS_VIEW = "comments";
	
	@RequestMapping(path = "/api/v1/comments", method = RequestMethod.GET)
	public String showComments(HttpServletRequest request,
			HttpServletResponse response,
			Model model) {
		
		return COMMENTS_VIEW;
	}

}
