package org.satabdi.javaResttutorial.messengerApp.annotations;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/annotations")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class CheckAnnotations {
	
	
	@GET
	public String testMatrixParams(@MatrixParam("param") String param) {
		//Test URL : http://localhost:8080/messengerApp/webapi/annotations;param=hello
		
		return param;
	}
	
	@GET
	@Path("headerParam")
	public String testHeaderParams(@HeaderParam("headerParam") String param) {
		//Test URL : http://localhost:8080/messengerApp/webapi/annotations/headerParam
		//headerParam=Satabdi in postman header
		
		
		System.out.println("Received Header Param : "+param);
		return param;
	}
	
	@GET
	@Path("cookieParam1")
	public String testCookieParams(@CookieParam("Cookie_2") String param) {
		//Test URL : http://localhost:8080/messengerApp/webapi/annotations/cookieParam1
		
		System.out.println("Received Cookie Param : "+param);
		return param;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo) {
		//Test URL : http://localhost:8080/messengerApp/webapi/annotations/context
		
		String path = uriInfo.getAbsolutePath().toString();
		
		System.out.println("I am in getParamsUsingContext : "+path);
		
		return path;
	}

}
