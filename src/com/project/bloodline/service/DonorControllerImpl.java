package com.project.bloodline.service;

import java.util.List;

import com.project.bloodline.dto.DonorDTO;
import com.project.bloodline.model.Donor;

public class DonorControllerImpl {

	
	public Donor createDonor(DonorDTO donorDTO) {
		System.out.println("Donot created");
		return null;
	}
	
	public Donor getDonorById(String donorId) {
		System.out.println("Donot fetched");

		return null;
	}
	
	public List<Donor> getAllDonors() {
		System.out.println("All Donot fetched");
		return null;
	}
	
	public void removeDonor(int donorId) {
		System.out.println("Donor with ID: " + donorId + " successfulley removed.");
	}
}
