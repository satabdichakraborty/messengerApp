package org.satabdi.javaResttutorial.messengerApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.satabdi.javaResttutorial.messengerApp.database.DatabaseClass;
import org.satabdi.javaResttutorial.messengerApp.model.Comment;
import org.satabdi.javaResttutorial.messengerApp.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long id) {
		System.out.println("Entering getAllComments...");
		
		Map<Long, Comment> comments = messages.get(id).getComments();
		
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getCommentById(long messageId, long commentId) {
		System.out.println("Entering getCommentsById...");
		
		Map<Long, Comment> comments = messages.get(commentId).getComments();
		
		return comments.get(commentId);
	}

	public Comment addComment(long messageId, Comment comment) {
		System.out.println("Entering addComments...");
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		System.out.println("Entering updateComment...");
		

		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		if(comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		System.out.println("Updated comment = "+comments.get(comment.getId()));

		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		System.out.println("Entering removeComment...");
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		return comments.remove(commentId);
	}
}
