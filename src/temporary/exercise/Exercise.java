package temporary.exercise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Exercise implements Serializable{
	
	String name = "Niesamowita wartosc stringu";
	int liczba = 123;
			
	
	public static void main(String[] arg) {
		try {
			String path = "C:\\Users\\w18154\\Desktop\\TestFolder\\file_output_stream.txt";
			File file = new File(path);
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			Exercise test=new Exercise();
			out.writeObject(test);
			out.close();
			fileOut.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
