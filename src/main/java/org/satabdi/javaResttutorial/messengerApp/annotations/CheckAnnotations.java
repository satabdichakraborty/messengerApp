package org.satabdi.javaResttutorial.messengerApp.annotations;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/annotations")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class CheckAnnotations {
	
	
	@GET
	public String testMatrixParams(@MatrixParam("param") String param) {
		//Test URL : http://localhost:8080/messengerApp/webapi/annotations;param=hello
		return param;
	}

}
