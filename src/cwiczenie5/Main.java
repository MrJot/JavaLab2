package cwiczenie5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Main {

	public static void main(String args[]) throws Exception {

		Bureau bureau = initBureau();
		printBureau(bureau);
		saveBureau(bureau, "mi6.ser");
		Bureau loadedBureau = loadBureau("mi6.ser");
//		Bureau loadedBureau = null;
		System.out.println("\n=======================");
		printBureau(loadedBureau);

	}

	private static void saveBureau(Bureau bureau, String filename) throws Exception {
		File file = new File(filename);
		FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
		outStream.writeObject(bureau);
		outStream.close();
		fileOut.close();

	}

	private static Bureau loadBureau(String filename) throws Exception {
		ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(filename));
		Bureau output = (Bureau) objIn.readObject();
		objIn.close();

		return output;
	}

	private static Bureau initBureau() {
		Bureau bureau = new Bureau("MI6");
		Agent agent007 = new Agent("James", "Bond", 35, "007");
		bureau.addAgent(agent007);

		Task task = new Task("darkMamba", "infiltrate, spy, destroy");
		agent007.addTask(task);

		return bureau;
	}

	private static void printBureau(Bureau bureau) {
		System.out.println("Bureau: " + bureau.getName());
		for (Agent b : bureau.getAgents()) {
			System.out.print("Name:" + b.getName() + ", " + "Surname:" + b.getSurname() + ", " + "Age:" + b.getAge()
					+ ", " + "Code:" + b.getNumber());
		}

	}

}
