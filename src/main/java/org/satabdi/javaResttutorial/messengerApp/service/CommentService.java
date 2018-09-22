package org.satabdi.javaResttutorial.messengerApp.service;

import java.util.Map;

import org.satabdi.javaResttutorial.messengerApp.database.DatabaseClass;
import org.satabdi.javaResttutorial.messengerApp.model.Comment;
import org.satabdi.javaResttutorial.messengerApp.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	private Map<Message, Comment> allComments = DatabaseClass.getComments();
	
	public Map<Message, Comment> getAllComments(long id) {
		System.out.println("Entering getAllComments...");
		
		System.out.println("Returning all comments so far ["+allComments.size()+"]");
		
		return allComments;
	}
	
	/*public Comment getCommentById(long messageId, long commentId) {
		System.out.println("Entering getCommentsById with messageId = "+messageId+ " : commentId = "+commentId);
		 
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		System.out.println("comments = "+comments);
		//System.out.println("comments = "+comments);
		Comment comment = comments.get(commentId);
		allComments.get(messages.get(messageId));
		
		System.out.println("Returning comment = "+comment);
		
		return comment;
	}*/
	
	public Comment getCommentById(long messageId, long commentId) {
		System.out.println("Entering getCommentsById with messageId = "+messageId+ " : commentId = "+commentId);
		
		System.out.println("/n/n/n messages = "+messages);
		
		System.out.println("/n/n/n allComments = "+allComments);
		
		Comment c = allComments.get(messageId);
		
		System.out.println("Returning comment = "+c);
		
		return c;
	}
	
	public Comment addComment(long messageId, Comment comment) {
		System.out.println("In addComment with comment = "+comment+ " & id = "+messageId);
		if(null != messages)
		{
		  // System.out.println("messages is not null = "+messages);
		   Message me = messages.get(messageId);
		   if(null != me) {
			//  System.out.println("/n......Got Message with id = "+m);
		      Map<Long, Comment> comments = me.getComments();
		      comment.setId(comments.size()+1);
		      comments.put(comment.getId(), comment);
		      System.out.println("comments = "+comments);
		      allComments.put(me, comment);
		   }
		}
		
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
