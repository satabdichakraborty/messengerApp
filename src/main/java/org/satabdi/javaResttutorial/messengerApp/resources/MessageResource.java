package org.satabdi.javaResttutorial.messengerApp.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
	
	/*@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<?> geAlltMessages() {
		
		// access URL http://localhost:8080/messengerApp/webapi/messages

		System.out.println("I am supposed to return all messages..");

		return msgService.getAllMessages();
	}*/

}
