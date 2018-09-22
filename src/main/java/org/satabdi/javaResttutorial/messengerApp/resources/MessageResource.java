package org.satabdi.javaResttutorial.messengerApp.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.satabdi.javaResttutorial.messengerApp.model.Message;
import org.satabdi.javaResttutorial.messengerApp.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService msgService = new MessageService();


	@GET
	public List<?> geAlltMessages(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size) {
		
		// access URL http://localhost:8080/messengerApp/webapi/messages

		System.out.println("I am supposed to return all messages..");
		
		if(year > 0) {
			return msgService.getAllMessagesByYear(year);
		}
		
		if(start > 0 && size > 0) {
			return msgService.getAllMessagesPaginated(start, size);
		}
		

		return msgService.getAllMessages();
	}

	@GET
	@Path("beanParamTest")
	public List<?> geAlltMessagesUsingBeanParam(@BeanParam MessageFilterBean bean) {
		
		// access URL http://localhost:8080/messengerApp/webapi/messages/beanParamTest

		System.out.println("I am supposed to return all messages..");
		
		if(bean.getYear() > 0) {
			return msgService.getAllMessagesByYear(bean.getYear());
		}
		
		if(bean.getStart() > 0 && bean.getSize() > 0) {
			return msgService.getAllMessagesPaginated(bean.getStart(), bean.getSize());
		}
		

		return msgService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessagesById(@PathParam("messageId") long messageId) {
		
		// access URL http://localhost:8080/messengerApp/webapi/messages/1
        //long msgId = Long.parseLong(messageId);
		System.out.println("Entering getMessagesById with id = "+messageId);
		Message m = msgService.getMessage(messageId);
		System.out.println("Message created at : "+m.getCreatedAt());

		return m;
	}
	
	@POST
	public Response addMessage(Message m) throws URISyntaxException {
		
		Message newMsg = msgService.addMessage(m);
		
		System.out.println("Adding a new message = "+m);
		
		//return Response.status(Status.CREATED).entity(newMsg).build();

		//return msgService.addMessage(m);
		
		return Response.created(new URI("messengerApp/webapi/messages/"+newMsg.getId())).entity(newMsg).build();
	}
	
	@PUT
	@Path("/update/{messageId}")
	public Message updateMessage(Message m, @PathParam("messageId") long id) {
		
		System.out.println("Updating an existing message with id= "+id);
        m.setId(id);
		return msgService.updateMessage(m);
	}
	
	@DELETE
	@Path("/delete/{messageId}")
	public void deleteMessagesById(@PathParam("messageId") long messageId) {
		
		// access URL http://localhost:8080/messengerApp/webapi/messages/1
        //long msgId = Long.parseLong(messageId);
		System.out.println("Entering deleteMessagesById with id = "+messageId);
		msgService.removeMessage(messageId);
	}
	
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
