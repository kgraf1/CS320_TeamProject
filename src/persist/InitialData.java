package persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.PhysicalModel;
import model.Profile;

public class InitialData {
	public static List<PhysicalModel> getPhysicalModels() throws IOException {
		List<PhysicalModel> modelList = new ArrayList<PhysicalModel>();
		ReadCSV readPhysicalModel = new ReadCSV("physicalModels.csv");
		try {
			// auto-generated primary key for physical model table
			Integer modelId = 1;
			while (true) {
				List<String> tuple = readPhysicalModel.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				PhysicalModel model = new PhysicalModel();
				model.setId(modelId++);
				/*set all the variables*/
				modelList.add(model);
			}
			return modelList;
		} finally {
			readPhysicalModel.close();
		}
	}
	
	public static List<Profile> getProfiles() throws IOException {
		List<Profile> profileList = new ArrayList<Profile>();
		ReadCSV readProfileList = new ReadCSV("profiles.csv");
		try {
			//auto-generated primary key for profile table
			Integer profileId = 1;
			while(true) {
				List<String> tuple = readProfileList.next();
				if(tuple == null) {
					break;
				}
				
				Iterator<String> i = tuple.iterator();
				Profile profile = new Profile();
				profile.setId(profileId++);
				profile.setUsername(i.next());
				profile.setPassword(i.next());
				profile.setFirstName(i.next());
				profile.setLastName(i.next());
				profile.setEmail(i.next());
				
				profileList.add(profile);
			}
			return profileList;
		} finally {
			readProfileList.close();
		}
	}

}

