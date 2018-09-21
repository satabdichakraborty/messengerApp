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

import org.satabdi.javaResttutorial.messengerApp.model.Message;
import org.satabdi.javaResttutorial.messengerApp.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService msgService = new MessageService();


	@GET
	public List<?> geAlltMessages() {
		
		// access URL http://localhost:8080/messengerApp/webapi/messages

		System.out.println("I am supposed to return all messages..");

		return msgService.getAllMessages();
	}

	
	@GET
	@Path("/{messageId}")
	public Message getMessagesById(@PathParam("messageId") long messageId) {
		
		// access URL http://localhost:8080/messengerApp/webapi/messages/1
        //long msgId = Long.parseLong(messageId);
		System.out.println("Entering getMessagesById with id = "+messageId);
		Message m = msgService.getMessage(messageId);
		System.out.println("Message created at : "+m.getCreated());

		return m;
	}
	
	@POST
	public Message addMessage(Message m) {
		
		System.out.println("Adding a new message = "+m);

		return msgService.addMessage(m);
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

}