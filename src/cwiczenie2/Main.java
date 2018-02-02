package cwiczenie2;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String string=null;
		
		while(true){
			System.out.println("Type something: ");
			string = input.nextLine();
			if(string.equals("exit")){
				break;
			}
			System.out.println("Output: "+string);
			
		}
		input.close();
	}
}
	


