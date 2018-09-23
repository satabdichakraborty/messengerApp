package org.satabdi.javaResttutorial.messengerApp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.satabdi.javaResttutorial.messengerApp.database.DatabaseClass;
import org.satabdi.javaResttutorial.messengerApp.exception.DataNotFoundException;
import org.satabdi.javaResttutorial.messengerApp.model.Message;

public class MessageService {
	
	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		Message m1 = new Message(1L, "Hello world", "Satabdi");
		Message m2 = new Message(2L, "Hi there", "Chinmoy");
		Message m3 = new Message(3L, "How are you", "Sandeep");
		Message m4 = new Message(4L, "Bye bye", "Darshan");

		messages.put(1L, m1);
		messages.put(2L, m2);
		messages.put(3L, m3);
		messages.put(4L, m4);
	}

	public List<?> getAllMessages() {

		System.out.println("Entering getAllMessages");

		System.out.println("About to return from getAllMessages : " + messages.size());

		return new ArrayList<Message>(messages.values());
	}
	
	public List<?> getAllMessagesByYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();

		System.out.println("Entering getAllMessagesByYear...");
		Calendar cal  = Calendar.getInstance();

		for(Message m : messages.values()) {
			cal.setTime(m.getCreatedAt());
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(m);
			}
		}
		return messagesForYear;
	}
	
	public List<?> getAllMessagesPaginated(int start, int size) {

		System.out.println("Entering getAllMessagesPaginated");

		System.out.println("About to return from messages starting at : "+start+ " : size = "+size);
		
		ArrayList<?> wholeList = new ArrayList<>(messages.values());
	
		return wholeList.subList(start, start+size);
	}

	public Message getMessage(long id) {
		System.out.println("Entering getMessage");
		
		Message msg = messages.get(id);
		if(msg == null) {
			throw new DataNotFoundException("Message with id = "+id+ " not found.");
		}
		
		return msg;
	}

	public Message addMessage(Message message) {
		System.out.println("Entering addMessage");
		messages.put(message.getId(), message);
		
		return message;
	}

	public Message updateMessage(Message message) {
		System.out.println("Entering updateMessage");
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		System.out.println("Updated msg = "+messages.get(message.getId()));

		return messages.get(message.getId());
	}
	
	public Message removeMessage(long id) {
		System.out.println("Entering removeMessage");
		
		return messages.remove(id);
	}
}
