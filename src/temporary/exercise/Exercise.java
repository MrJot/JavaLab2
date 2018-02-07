package temporary.exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Exercise implements Serializable{
	
	String name = "Niesamowita wartosc stringu, ktora z tego co mi sie wydaje, to jest zapisana jako funktor";
	int liczba = 123;
	
	public static void writeObjectToExternalFile(String path, Object test) {
		try {
			File file = new File(path);
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(test);
			out.close();
			fileOut.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		Exercise toReturn = null;
		try {
			File file = new File(path);
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			toReturn = (Exercise) in.readObject();
			System.out.println(toReturn.liczba);
			System.out.println(toReturn.name);
			in.close();
			fileIn.close();
		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Exercise readObjectFromExternalFile(String path) {
		Exercise toReturn = null;
		try {
			File file = new File(path);
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			toReturn = (Exercise) in.readObject();
			System.out.println(toReturn.liczba);
			System.out.println(toReturn.name);
			in.close();
			fileIn.close();
		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
			
	
	public static void main(String[] arg) {
		
		
	}

}
