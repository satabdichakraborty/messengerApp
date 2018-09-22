package org.satabdi.javaResttutorial.messengerApp.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Timestamp createdAt;
	private String author;
	private Map<Long, Comment> comments = new HashMap<>();
	
	
	public Message() {}
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		this.createdAt = ts;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Message Id =" +this.id+ " : message = ["+this.message+"] : createdAt = "+this.createdAt+ " : author = "+this.author;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	
}
