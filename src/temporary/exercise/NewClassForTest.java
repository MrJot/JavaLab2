package temporary.exercise;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class NewClassForTest implements Serializable{
	public static void main(String[] args) {
		Exercise toReturn = null;
		String path = "C:\\Users\\w18154\\Desktop\\TestFolder\\file_output_stream.txt";
		try {
//			File file = new File(path);
			FileInputStream fileIn = new FileInputStream(path);
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

}
