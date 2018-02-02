package cwiczenie3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static String[] stringsToBeWritten = { "Joh Woo 001", "Robert Duval 002", "James Bond 007" };

	public static void main(String args[]) throws Exception {
		for (int i=0;i<10;i++){
			saveAgents(stringsToBeWritten, "res/cwiczenie3/special-agents.txt",true);
		}
		randAccessFile();
		
	}

	private static void saveAgents(String[] agents, String filename, boolean ifOverwrite) throws Exception {
		if(ifOverwrite){
			System.out.println("New content has been added to the "+filename);
		}else{
			System.out.println(filename + " has been overwritten");
		}
		
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File(filename),ifOverwrite));
		for(String word:agents){
			//System.out.println(word);
			pw.println(word);
		}
		pw.flush();
	}
	
	public static void randAccessFile() throws IOException{
		String filename =  "res/cwiczenie3/special-agents.txt";
		RandomAccessFile raf = new RandomAccessFile(filename, "rw");
		raf.seek(4);
		raf.writeBytes(" newString ");
		
	}
}
