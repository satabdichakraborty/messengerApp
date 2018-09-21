package org.satabdi.javaResttutorial.messengerApp.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.satabdi.javaResttutorial.messengerApp.model.Message;
import org.satabdi.javaResttutorial.messengerApp.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService msgService = new MessageService();

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String getMessages() { return
	 * "Hello from my rest api - GET http method !"; //access URL
	 * http://localhost:8080/messengerApp/webapi/messages }
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<?> geAlltMessages() {
		
		// access URL http://localhost:8080/messengerApp/webapi/messages

		System.out.println("I am supposed to return all messages..");

		return msgService.getAllMessages();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages() {
		
		// access URL http://localhost:8080/messengerApp/webapi/messages/test

		System.out.println("Entering getMessages");

		return "test";
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessagesById(@PathParam("messageId") long messageId) {
		
		// access URL http://localhost:8080/messengerApp/webapi/messages/1
        //long msgId = Long.parseLong(messageId);
		System.out.println("Entering getMessagesById with id = "+messageId);
		Message m = msgService.getMessage(messageId);
		System.out.println("Message created at : "+m.getCreated());

		return m;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message m) {
		
		System.out.println("Adding a new message = "+m);

		return msgService.addMessage(m);
	}

}
