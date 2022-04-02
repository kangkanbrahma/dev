package com.project.bloodline.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;


@Provider
public class SecurityFilter implements ContainerRequestFilter {

	@Context
    private ResourceInfo resourceInfo;
     
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "bloodline";


	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
	
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			Method method = resourceInfo.getResourceMethod();
			
			if(method.isAnnotationPresent(PermitAll.class)) return;
			
			
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if(authHeader != null && authHeader.size() > 0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodeAsString = new String(Base64.getDecoder().decode(authToken));
				StringTokenizer stringTokenizer = new StringTokenizer(decodeAsString, ":");
				String username = stringTokenizer.nextToken();
				String password = stringTokenizer.nextToken();
				System.out.println("User : " + username + " " + "Password : " + password);
				
				if(method.isAnnotationPresent(RolesAllowed.class))
	            {
	                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
	                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
	                  
	                //Is user valid?
	                if(isUserAllowed(username, password, rolesSet))
	                {
	                    return;
	                }
	            }
//				if("user".equalsIgnoreCase(userName) && "password".equalsIgnoreCase(password)) return;
			}
			
			Response build = Response
					.status(Response.Status.UNAUTHORIZED)
					.entity("User cannot access the resource...")
					.build();
			requestContext.abortWith(build);
		}
		
	}


	private boolean isUserAllowed(String username, String password, Set<String> rolesSet) {
		// TODO Auto-generated method stub
		if (rolesSet.contains("USER")) return true;
		return false;
	}

	
}
