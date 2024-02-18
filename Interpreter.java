import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Interpreter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileReader fileName = new FileReader("C:\\Mine\\Classes\\SPRING 2024\\CMSC 4513\\multiply.txt");
			BufferedReader buffer = new BufferedReader(fileName);
			String line = "";
			Stack<String> mystack = new Stack<String>();

			
			while((line = buffer.readLine()) != null) {
				//System.out.println("" + line);
				runProgram(line, mystack);
			}
		
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void runProgram(String line, Stack<String> mystack) 
	{
		
		
		String[] splittedLine = line.split(" ", 2);
		int size = splittedLine.length;
		
		String key = splittedLine[0];
		
		if(!Character.isLetter(key.charAt(0)))
			key = key.substring(1);

		if(key.equals("COUT")) {
			if(splittedLine.length>1) {
				System.out.println(splittedLine[1]);
			}
			else {
				if(!mystack.isEmpty())
					System.out.println(mystack.firstElement());
				// it will read whatever is on the stack at that time.
			}
		}
		
		else if (key.equals("CIN")) {
			Scanner scanner = new Scanner(System.in);
			mystack.add(scanner.nextLine());
		}
		else if(key.equals("MUL")) {
			if(mystack.size()<2) {
				System.out.println("not enough element");
			}
			else {
				int first = Integer.valueOf(mystack.pop());
				int second = Integer.valueOf(mystack.pop());
				mystack.push(""+first*second);
			}
		}
			
	}
}
