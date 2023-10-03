package edu.depaul;

public class RegularPatient extends Patient {

	private String mainSymptom;

	public RegularPatient(int id, String fName, String lName, int age, String mainSymptom) {
		super(id, fName, lName, age);
		this.mainSymptom = mainSymptom;
	}

	@Override
	public String treat() {
		// TODO Auto-generated method stub
		String res;
		if (mainSymptom.equalsIgnoreCase("coughing") || mainSymptom.equalsIgnoreCase("runny nose")
				|| mainSymptom.equalsIgnoreCase("stuffy nose")) {
			res = "Amoxicillin";
		} else if (mainSymptom.equalsIgnoreCase("hypertension")) {
			res = "ACE inhibitors";
		} else {
			res = "IV fluids";
		}
		return res;
	}

	@Override
	public String toString() {
		return " RegularPatient:\n" + " Id:" + getId() + "\n "
				+((getfName() != null && getlName() != null) ? "full Name: " + getfName() + getlName() + "\n " : "")
				+ "Age:" + getAge() + "\n " + (mainSymptom != null ? "Main Symptom:" + mainSymptom + "\n " : "")
				+ "PCR test result:" + (super.getPcr() ? "positive" : "negative"+"\n")
				+ (treat() != null ? "Treatment :" + treat() + "\n " : "");
	}

}
