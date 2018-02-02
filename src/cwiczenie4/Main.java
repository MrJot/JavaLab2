package cwiczenie4;

import java.io.File;
import java.io.FilenameFilter;
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
		
		printFiles("/Users/grzegorzjuszkiewicz/Desktop/Java/pl/project/encryption",".java");
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
	
	public static void printFiles(String path, String extensionFilter) {
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(extensionFilter);
			}
		};
		
	}

	public static void printTree(String path) {
		// to be implemented
		// Example
		// dirname
		// dirname/file1
		// dirname/file2
		// dirname/dirname1
		// dirname/dirname1/file1
		// dirname/dirname1/file2
		// dirname/dirname2/file1
	}

}
