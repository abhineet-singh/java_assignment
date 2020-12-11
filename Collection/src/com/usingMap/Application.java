package com.usingMap;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		BloodDonor b1 = new BloodDonor("1Xy", "Abhineet", 22, "O+");
		BloodDonor b2 = new BloodDonor("1ZY","Abhineet2", 22, "O+");
		BloodDonor b3 = new BloodDonor("1ZY","Abhineet3", 22, "O-");

		BloodDonorService service = new BloodDonorService();
		
		service.addDonorToGroup(b1);
		service.addDonorToGroup(b2);
		service.addDonorToGroup(b3);
		
		List<BloodDonor> list = service.printDonorOfGroup("O+");
		
		for(BloodDonor donor : list) {
			System.out.println(donor);
		}

	}

}
