package org.satabdi.javaResttutorial.messengerApp.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	
	private long id;
	private String message;
	private Timestamp createdAt;
	private String author;
	
	public Comment() {}
	
	public Comment(long id, String message, String author) {
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
		return "Comment Id =" +this.id+ " : comment msg = ["+this.message+"] : createdAt = "+this.createdAt+ " : author = "+this.author;
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
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
