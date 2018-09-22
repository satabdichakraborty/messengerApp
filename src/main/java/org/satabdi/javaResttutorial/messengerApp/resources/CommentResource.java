package org.satabdi.javaResttutorial.messengerApp.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.satabdi.javaResttutorial.messengerApp.model.Comment;
import org.satabdi.javaResttutorial.messengerApp.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService commentService  = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	
	@POST
	public Comment addComment(@PathParam("messageId") String messageId, Comment comment) {
		System.out.println("In addComment with messageId = "+messageId+" : comment ="+comment);
		
		return commentService.addComment(Long.getLong(messageId), comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") String messageId, @PathParam("commentId") String commentId, Comment comment) {
		System.out.println("In updateMessage ..");
		comment.setId(Long.parseLong(commentId));
		return commentService.updateComment(Long.parseLong(messageId), comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment removeComment(@PathParam("messageId") String messageId, @PathParam("commentId") String commentId) {
		System.out.println("In removeComment ..");
		
		return commentService.removeComment(Long.parseLong(messageId), Long.parseLong(commentId));
	}
	

}
