package zadanie2;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

	
	
	
	public void complexFileListening() throws IOException {
		
//		Date format definition
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		File[] listOfFiles = new File(getPath()).listFiles();
//		Headers for table
		System.out.format("%s","File name");
		System.out.format("%30s", "Size");
		System.out.format("%30s%n", "Date");
//		main loop definition
		for(File file:listOfFiles) {
//			Path pathNew = Paths.get(file.toString());	
			BasicFileAttributes attr = Files.readAttributes(Paths.get(file.toString()), BasicFileAttributes.class);
			System.out.format("%-35s",file.getName());
			if(attr.isDirectory()) {
				System.out.format("%-25s","DIR");
			}else {
				System.out.format("%-25d",(attr.size()));	
			}
			System.out.println(String.format("%s", df.format(attr.creationTime().toMillis())));
//			System.out.format("%d%n",(attr.size())/(1024)); //25 leading characters, decimal integer, new line
			
		}

	}
	
	public void listFileWithSpecificFileExtension() throws IOException {
		System.out.println("Provide requested file extension (Example: txt): ");
		String extensionFilter = scan.nextLine();
		FilenameFilter filter = new FilenameFilter() {
	        public boolean accept(File directory, String fileName) {
	        	if(fileName.endsWith(extensionFilter)) {
	        		return true;
	        	}else {
	        		return false;
	        	}
	        	
	        }
	};
	File file = new File(path);
	File[] listOfFiles = file.listFiles(filter);
	if(listOfFiles.length==0) {
		System.out.println("File not found :-(. Nothing to print here.");
	}else {
		System.out.format("Found %d file/s: "+System.lineSeparator(),listOfFiles.length);
	}
	for(File f:listOfFiles) {
			System.out.println(f.getName());	
	}
		
	}
	
	public void printFileTree(String path) throws IOException {
		File file = new File(path);
		File[] listOffiles = file.listFiles();
		for(File f:listOffiles) {
			System.out.println(f.getCanonicalPath());
			if(f.isDirectory()) {
				printFileTree(f.getCanonicalPath()); 
//			}else {
////				break;
//			}
		}
		}
	}
	
	public void setAnalysisPath() {
		System.out.println("Provide full path to your folder: ");
//		setPath(scan.nextLine());
		setPath("C:\\Users\\w18154\\Desktop\\TestFolder");
	}
	
	public void selectYourOperation() throws IOException {
		System.out.println("[1] - Simple file listening\n" + "[2] - Complex file listening\n"
				+ "[3] - List file with specific file extension  " + "\n[4] - Print file/folder tree");
		setUserOption(scan.nextInt());
		scan.nextLine();
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
			printFileTree(getPath());
			break;
		default:
			System.out.println("Something went wrong.Goodbye :-(");
			break;
				
		}
	}
	
	public void run() throws IOException {
		welcomeMessage();
		setAnalysisPath();
		selectYourOperation();
	}

	public static void main(String args[]) throws IOException {
		Commander command = new Commander();
		command.run();
	}

}
