package com.usingMap;

import java.util.*;


public class BloodDonorService {
	
	private HashMap<String,ArrayList<BloodDonor>> bloodDonorMap;

	public BloodDonorService() {
		this.bloodDonorMap = new HashMap<>();
	}
	
	public boolean addDonorToGroup(BloodDonor donor) {
		
		ArrayList<BloodDonor> donorList = bloodDonorMap.get(donor.getBloodGroup());

	    if(donorList == null) {
	    	donorList = new ArrayList<BloodDonor>();
	    	donorList.add(donor);
	    	this.bloodDonorMap.put(donor.getBloodGroup(), donorList);
	    } 
	    else {
	        if(!donorList.contains(donor)) {
	        	donorList.add(donor);
	        }
	        else {
	        	return false;
	        }
	    }
	    
	    return true;
	}
	
	public List<BloodDonor> printDonorOfGroup(String bloodGroup) {
		
		ArrayList<BloodDonor> list = this.bloodDonorMap.get(bloodGroup);
	
		return list;
	}

}
