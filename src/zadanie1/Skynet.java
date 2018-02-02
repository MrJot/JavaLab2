package zadanie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Skynet {
	
	private String login = "Reese";
	private String password = "#Terminate";
		
	public static void main(String args[]) {
		Skynet skynet = new Skynet();
		skynet.run();
	}
	
	public void run() {
		readCredentials();
		printSkyNetLogo();
		runLoginPanel();
	}
	
	private void runLoginPanel() {
		String readLogin;
		String readPassword;
		boolean credentialsOK;
		do {
			System.out.println("Login: ");readLogin = getTextFromInput("Login");
			System.out.println("Password: ");readPassword = getTextFromInput("Password");
			credentialsOK = verifyCredentials(readLogin, readPassword); 
			if (!credentialsOK) {
				System.out.println("Wrong login or password. Try again.");
			}
		} while (!credentialsOK);
		System.out.println();
		System.out.println("Welcome to SKYNET...");
	}
	
	private String getTextFromInput(String label) {
		Scanner scan = new Scanner(System.in);
		String userInput = scan.next();
		//scan.close();
		return userInput;
	}
	
	private boolean verifyCredentials(String login, String password) {
		return this.login.equals(login) && this.password.equals(password);
	}
	 
	private void readCredentials() {
		String file = "res/zadanie1/skynet.conf";
		File poemFile = new File(file);
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
			String line = null;
			String login = reader.readLine();
			String password = reader.readLine();
			if(verifyCredentials(login, password)){
				System.out.println("INFO System reconfigured...");
			}else{
				System.out.println("INFO No valid conf data");
			}
			}			 catch (IOException x) {
			System.err.format("IOException: %s", x);
		}


}

	
	private void printSkyNetLogo() {
		String file = "res/zadanie1/logo.txt";
			File poemFile = new File(file);
			try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}			} catch (IOException x) {
				System.err.format("IOException: %s", x);
			}


	}
}
