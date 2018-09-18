package org.satabdi.javaResttutorial.messengerApp.service;

import java.util.ArrayList;
import java.util.List;

import org.satabdi.javaResttutorial.messengerApp.model.Message;


public class MessageService {

	public List<?> getAllMessages(){
		
		System.out.println("Entering getAllMessages");
		
		Message m1 = new Message(1L, "Hello world", "Satabdi");
		Message m2 = new Message(2L, "Hi there", "Satabdi");
		Message m3 = new Message(3L, "How are you", "Satabdi");
		Message m4 = new Message(4L, "Bye bye", "Satabdi");
		
		List<Message> messageList = new ArrayList<Message>();
		messageList.add(m1);
		messageList.add(m2);
		messageList.add(m3);
		messageList.add(m4);
		
		System.out.println("About to return from getAllMessages : "+messageList.size());
		
		
		return messageList;
		
	}
}
