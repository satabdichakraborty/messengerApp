
package org.satabdi.javaResttutorial.messengerApp.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.satabdi.javaResttutorial.messengerApp.model.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		
		ErrorMessage err = new ErrorMessage(exception.getMessage(), 404, "Upcoming site!");
		
		return Response.status(Status.NOT_FOUND).entity(err).build();
	}
	

}
