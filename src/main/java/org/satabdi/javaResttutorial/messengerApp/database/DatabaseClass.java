package org.satabdi.javaResttutorial.messengerApp.database;

import org.satabdi.javaResttutorial.messengerApp.model.Comment;
import org.satabdi.javaResttutorial.messengerApp.model.Message;
import org.satabdi.javaResttutorial.messengerApp.model.Profile;
import java.util.*;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	
	private static Map<String, Profile> profiles = new HashMap<>();
	
	private static Map<Message, Comment> comments = new HashMap<>();

	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	public static Map<Message, Comment> getComments() {
		return comments;
	}

}
