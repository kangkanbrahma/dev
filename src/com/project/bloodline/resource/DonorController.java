package com.project.bloodline.resource;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.bloodline.dto.DonorDTO;
import com.project.bloodline.service.DonorControllerImpl;

@Path("/bloodline")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON )
public class DonorController {
	
	DonorControllerImpl donorControllerImpl = new DonorControllerImpl();
	
	@RolesAllowed("USER")
	@POST
	@Path("donors")
	public Response createDonor(DonorDTO donorDTO) {
		donorControllerImpl.createDonor(donorDTO);
		return Response.status(Response.Status.CREATED).entity("").build();
	}
	
	@PermitAll
	@GET
	@Path("donors")
	public Response getAllDonors(){
		donorControllerImpl.getAllDonors();
		return Response.status(Response.Status.OK).entity("").build();
	}
	

	
	@RolesAllowed("USER")
	@GET
	@Path("donors/id/{donorId}")
	public Response getDonorById(@PathParam("donorId") String donorId) {
		donorControllerImpl.getDonorById(donorId);
		return Response.status(Response.Status.OK).entity("").build();
	}

}
