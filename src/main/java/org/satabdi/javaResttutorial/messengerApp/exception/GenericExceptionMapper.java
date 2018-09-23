package org.satabdi.javaResttutorial.messengerApp.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.satabdi.javaResttutorial.messengerApp.model.ErrorMessage;


//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		
		ErrorMessage err = new ErrorMessage(exception.getMessage(), 500, "Upcoming site!");
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).build();
	}
	

}
