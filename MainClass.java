package edu.depaul;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	private ArrayList<Patient> patients = new ArrayList<>();

	public MainClass() {

		int number = 0;
		// Create a Scanner object
		Scanner scanner = new Scanner(System.in);

		while (true) {
			displayMenu();
			try {
				System.out.print("Please enter a number from 1 to 6 for display: ");
				number = scanner.nextInt();
				scanner.nextLine();

				if (number == 6)
					break; // Exit

				switch (number) {
				case 1:
					admitPatient(scanner);
					break;
				case 2:
					printPatientInfo();
					break;
				case 3:
					submitPCRResult(scanner);
					break;
				case 4:
					doRounds(scanner);
					break;
				case 5:
					dischargePatients();
					break;
				default:
					System.out.println("Invalid choice. Please choose a number between 1 and 6.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				// To clear invalid input
				scanner.nextLine(); 
			}
		}

		System.out.println("Exit.");
		scanner.close();
	}

	private void admitPatient(Scanner scanner) {
		System.out.println("Admit a patient");
//		PCR test result is negative or positive
		System.out.println("plz tell me your PCR test result is negative or positive (y/n):");
//		read user's input 
		String PCR = scanner.nextLine();
//		PCR positive then Covid19 patient
//		int id, String fName, String lName, int age , double temperature
		if (PCR.equalsIgnoreCase("y")) {
			System.out.println("plz tell me ur id:\n");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("plz tell me ur first name:\n");
			String fName = scanner.nextLine();
			System.out.println("plz tell me ur last name:\n");
			String lName = scanner.nextLine();
			System.out.println("plz tell me ur age:\n");
			int age = scanner.nextInt();
			scanner.nextLine();
			System.out.println("plz tell me ur temperature:\n");
			double temperature = scanner.nextDouble();
			scanner.nextLine();

//			create and record a new patient
			Covid19Patient positivePatient = new Covid19Patient(id, fName, lName, age, temperature);
			positivePatient.setPcr(true);
			patients.add(positivePatient);
		} else { 
			System.out.println("plz tell me ur id:\n");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("plz tell me ur first name:\n");
			String fName = scanner.nextLine();
			System.out.println("plz tell me ur last name:\n");
			String lName = scanner.nextLine();
			System.out.println("plz tell me ur age:\n");
			int age = scanner.nextInt();
			scanner.nextLine();
			System.out.println("plz tell me ur main Symptom:\n");
			String mainSymptom = scanner.nextLine();
//			create and record patient 
			RegularPatient negativePatient = new RegularPatient(id, fName, lName, age, mainSymptom);
			negativePatient.setPcr(false);
			patients.add(negativePatient);
		}

		System.out.println("successfully admitted.");

	}

	private void printPatientInfo() {
		System.out.println("Print patient information");
		for (Patient patient : patients) {

			System.out.println(patient.toString());
		}
	}

	private void submitPCRResult(Scanner scanner) {
		System.out.println("Submit a PCR test result");
//		get the patient id
		System.out.println("plz tell me ur id: \n");
		int id = scanner.nextInt();
		scanner.nextLine();
//		

//		get the PCR result 
		System.out.println("plz tell me your PCR test result is negative or positive (y/n):");
		String pcrUpdate = scanner.nextLine();

//		throw new ConcurrentModificationException()			
		List<Patient> toRemove = new ArrayList<>();
		for (Patient patient : patients) {
			if (patient.getId() == id) {
				if (pcrUpdate.equalsIgnoreCase("y")) {
					patient.setPcr(true);
//					positive
//					check if he is regular patient 

					if (patient instanceof RegularPatient) {
//						get temperature
						System.out.println("plz tell me ur temperature:\n");
						double temperature = scanner.nextDouble();
						scanner.nextLine();
//						update regular to covid Patient
						Covid19Patient RegularPatientUpdate = new Covid19Patient(patient.getId(), patient.getfName(),
								patient.getlName(), patient.getAge(), temperature);
						patient = RegularPatientUpdate;
					}

				} else {
					patient.setPcr(false);
//					negative
//					check if he is covid19 patient

					if (patient instanceof Covid19Patient) {
//						RegularPatient(int id, String fName, String lName, int age,String mainSymptom)
//						get mainSymptom

//						discharge patients 
//						patients.remove(patient);
						toRemove.add(patient);
						System.out.println("patients discharged .");
					}

				}
			}
		}

		patients.removeAll(toRemove);
	}

	private void doRounds(Scanner scanner) {
		for (Patient patient : patients) {
			if (patient instanceof Covid19Patient) {
				System.out.println("plz tell me ur temperature:\n");
				double temperature = scanner.nextDouble();
				scanner.nextLine();
				((Covid19Patient) patient).setTemp(temperature);
				String treatment = patient.treat();
				System.out.println("patient:" + patient.getId() + "\n" + "treatment:" + treatment + "\n");
			}
		}
	}

	private void dischargePatients() {
//		throw new ConcurrentModificationException()
		List<Patient> toDischarge = new ArrayList<>();
		for (Patient patient : patients) {
			if (patient.getPcr() == false) {
				toDischarge.add(patient);
				System.out.println(patient.getfName() + patient.getlName() + " " + "discharged" + "\n");
			}
		}
		patients.removeAll(toDischarge);
	}

	private void displayMenu() {
		System.out.println("1. Admit a patient\n");
		System.out.println("2. Print patient information\n");
		System.out.println("3. Submit a PCR test result\n");
		System.out.println("4. Do rounds\n");
		System.out.println("5. Discharge patient\n");
		System.out.println("6. Exit\n");
	}

	public static void main(String[] args) {
		new MainClass();
	}
}
