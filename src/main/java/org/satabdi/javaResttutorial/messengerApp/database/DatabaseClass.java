package org.satabdi.javaResttutorial.messengerApp.database;

import org.satabdi.javaResttutorial.messengerApp.model.Message;
import org.satabdi.javaResttutorial.messengerApp.model.Profile;
import java.util.*;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	
	private static Map<Long, Profile> profiles = new HashMap<>();

	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}

}
