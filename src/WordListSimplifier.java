import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordListSimplifier {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		PrintWriter pw;
		String tStr;
		int count = 0;
		
		try {
			//Reads old file
			Scanner inFile = new Scanner(new File("totalWords.txt"));
			while(inFile.hasNextLine()) {
				tStr = inFile.nextLine();
				if(tStr.length() == 3 || tStr.length() == 4 || 
						tStr.length() == 7 || tStr.length() == 10) {
					words.add(tStr);
				}
				count++;
			}
			inFile.close();
			//Prints new file
			pw = new PrintWriter("newWords.txt", "UTF-8");
			for(int i = 0; i < words.size(); i++) {
				pw.println(words.get(i));
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("We removed %d words, leaving you with merely %d words\n"
				,count-words.size(),words.size());
	}
}
