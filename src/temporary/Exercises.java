package temporary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Exercises implements Serializable {
	
	String nazwa = "jakaœ nazwa";
	int liczba = 5;
	
	public Exercises() {
		
	}

	public static void main(String[] args) {

		
		try {
			File file = new File("C:\\Users\\w18154\\Desktop\\TestFolder\\file_output_stream.txt");
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			Exercises ex = new Exercises();
			out.writeObject(ex);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
