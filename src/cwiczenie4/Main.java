package cwiczenie4;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String args[]) throws Exception {
//		printFilesSimple("C:\\");
		//printFilesDetails("C:\\");
		//printFiles("C:\\", ".txt");
		//printTree("C:\\");
		
		printTree("C:\\Users\\w18154\\Desktop\\TestFolder");
	}
 
	public static void printFilesSimple(String path) {
		
//		File folder = new File(path);
//		File[] folderContent=folder.listFiles();
//		
//		for (File file:folderContent) {
//			file.delete();
//		}
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			System.out.println(file.getName());
		}
	}

	public static void printFilesDetails(String path) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd mm:ss");
		File singleFile = new File(path);
		File[] listOfFiles = singleFile.listFiles();
//		System.out.println(new char[50]);
		String labelOne = "File name";
		String labelTwo = "Size";
		String labelThree ="Date";
		
				
		System.out.format("%s","File name");
		System.out.format("%30s", "Size");
		System.out.format("%30s%n", "Date");
		
		for(File file:listOfFiles) {
			Path pathNew = Paths.get(file.toString());			
			BasicFileAttributes attr = Files.readAttributes(pathNew, BasicFileAttributes.class);
			int len = file.getName().length();
//			System.out.println(len);
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
	
	public static void printFiles(String path, String extensionFilter) throws IOException {
		
		FilenameFilter filter = new FilenameFilter() {
	        public boolean accept(File directory, String fileName) {
	        	if(fileName.endsWith(extensionFilter)) {
	        		return true;
	        	}else {
	        		System.out.println("no such file");
	        		return false;
	        	}
	        	
	        }
	};
	File file = new File(path);
	File[] listOfFiles = file.listFiles(filter);
	for(File f:listOfFiles) {
		System.out.println(f.getCanonicalPath());
	}
	
	}

	public static void printTree(String path) throws IOException {
		
		File file = new File(path);
		File[] listOffiles = file.listFiles();
		for(File f:listOffiles) {
			System.out.println(f.getCanonicalPath());
			if(f.isDirectory()) {
				printTree(f.getAbsolutePath()); 
//			}else {
////				break;
//			}
		}
		}
	}
}
