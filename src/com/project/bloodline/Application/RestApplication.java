package com.project.bloodline.Application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.project.bloodline.security.SecurityFilter;

@ApplicationPath("/rest")
public class RestApplication extends ResourceConfig{
	public RestApplication() {
		packages("com.project.bloodline");
		register(SecurityFilter.class);
	}
}
