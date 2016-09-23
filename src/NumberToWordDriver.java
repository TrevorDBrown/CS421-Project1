import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberToWordDriver {
	public static void main(String[] args) {
		File inFile;
		WordTree<String> wt = null;
		
		Scanner in = new Scanner(System.in);
		String input = "";
		
		try {
			inFile = new File("src/wordlist.txt");
			wt = buildTree(inFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		while(input == "") {
			try {
				System.out.println("Please enter a phone number you'd like");
				System.out.println("to test. (1-###-###-####)");
				input = in.nextLine();
			
				if(inFormat(input)) {
					in.close();
				} else {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Incorrect input. Please try again.");
				input = "";
			}
		}
		if(in != null) {
			in.close();
		}
		//Input received
		//Begin analysis
		if(wt!=null) {
			wt.method1(input);
		}
		
//		numToWord(input);
		
		//Print solution
		System.out.printf("Your number is %s.", input);
	}

	private static void numToWord(String n) {
		
	}
	
	private static WordTree<String> buildTree(File inFile) throws IOException {
		WordTree<String> wt = new WordTree<String>();
		Scanner words = new Scanner(inFile);
		while(words.hasNextLine()) {
			wt.add(words.nextLine());
		}
		words.close();
		return wt;
	}

	/**
	 * Ensures that the input string is in the proper format for phone numbers in the US.
	 * @param input - String to be checked
	 * @return boolean - Whether the string is proper (true) or not (false)
	 */
	private static boolean inFormat(String input) {
		char c;
		if(input.length() == 12) {
			for(int i = 0; i < input.length(); i++) {
				c = input.charAt(i);
				if(i==3 || i==7) {
					if((int)c!=45) { //Makes sure the char is '-'
						return false;
					}
				} else {
					if((int)c < 47) {
						return false;
					} else if((int)c > 58) {
						return false;
					}
				}
			}
			return true;
		} else {
			//If the length isn't 12...
			return false;
		}
	}
}
