package zadanie2;

import java.io.File;
import java.util.Scanner;

public class Commander {
	Scanner scan = new Scanner(System.in);

	

	private int userOption;
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getUserOption() {
		return userOption;
	}

	public void setUserOption(int userOption) {
		this.userOption = userOption;
	}

	public void welcomeMessage() {
		System.out.println("This is simple NortonCommander.");
	}
	
	
//  Stuff which do actual work
//	Is starting from 
//	now

	public void simpleFileListening() {
		File file = new File(getPath());
		File[] listOfFiles = file.listFiles();
		System.out.println(">>>Requested list of files is:");
		for(File f:listOfFiles) {
			System.out.println(f.getName());
		}
	
	}

	
	
	
	public void complexFileListening() {

	}
	
	public void listFileWithSpecificFileExtension() {
		
	}
	
	public void printFileTree() {
		
	}
	
	public void setAnalysisPath() {
		System.out.println("Provide full path to your folder: ");
		setPath(scan.nextLine());
	}
	
	public void selectYourOperation() {
		System.out.println("[1] - Simple file listening\n" + "[2] - Complex file listening\n"
				+ "[3] - List file with specific file extension  " + "\n[4] - Print file/folder tree");
		setUserOption(scan.nextInt());
		switch(getUserOption()) {
		case 1:
			simpleFileListening();
			break;
		case 2:
			complexFileListening();
			break;
		case 3:
			listFileWithSpecificFileExtension();
			break;
		case 4:
			printFileTree();
			break;
		default:
			System.out.println("Something went wrong.Goodbye :-(");
			break;
				
		}
	}
	
	public void run() {
		welcomeMessage();
		setAnalysisPath();
		selectYourOperation();
	}

	public static void main(String args[]) {
		Commander command = new Commander();
		command.run();
	}

}
