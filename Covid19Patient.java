package edu.depaul;

public class Covid19Patient extends Patient{
	private double temperature;
	public Covid19Patient(int id, String fName, String lName, int age , double temperature) {
//		super(id,fName, lName, age);
//		for extend to Covid19Patient and RegularPatient
		super(id, fName, lName, age);
		this.temperature = temperature;
	}

	


	/**
	 * @return the temperature
	 */
	public double getTemp() {
		return temperature;
	}




	/**
	 * @param temperature the temperature to set
	 */
	public void setTemp(double temperature) {
		this.temperature = temperature;
	}



	@Override
	public String treat() {
		// TODO Auto-generated method stub
		
		String medicine ;
		if(temperature>=40) {
			medicine = "Dexamethasone";
		}
		
		if(getAge()>=59 && temperature>=36.5) {
			medicine = "Paxlovid";
		} else {
			medicine = "fluids and Acetaminophen";
		}
		
		
		
		return medicine;
	}

	@Override
	public String toString() {

		
		return " Covid19Patient:\n" + " Id:" + getId() + "\n "
		+((getfName() != null && getlName() != null) ? "full Name: " + getfName() + getlName() + "\n " : "")
		+ "Age:" + getAge() + "\n " 
		+ "temperature : " + temperature +"\n"
		+ " PCR test result:" + (getPcr() ? "positive" : "negative") + "\n"
		+ (treat() != null ? " Treatment :" + treat() + "\n " : "");
	}

}
