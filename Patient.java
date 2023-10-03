package edu.depaul;

//abstract class Patient 
public abstract class Patient {
	private int id;
	private String fName;
	private String lName;
	private int age;
	private boolean pcr;
	
	public Patient(int id, String fName, String lName, int age ) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the pcr
	 */
	public boolean getPcr() {
		return pcr;
	}

	/**
	 * @param pcr the pcr to set
	 */
	public void setPcr(boolean pcr) {
		this.pcr = pcr;
	}
	
	public abstract String treat();

	@Override
	public String toString() {
		return "id:" + getId() + "\n" + ((fName != null && lName != null )? "full Name: " + fName + lName+ "\n " : "")
				 + "age:" + age + "\n"+ " pcr:" + pcr + "\n";
	}	
}

