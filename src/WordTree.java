import java.util.ArrayList;

public class WordTree<T> {
	private Node root;

	public WordTree() {
		this.root = new Node();
	}
	
	/**
	 * 
	 * @prerequisite - s must be passes in the format ###-###-####
	 * @param s
	 * @return
	 */
	public void find(String s) {
		s = formatPhoneNum(s);
		
		ArrayList<String> sol7;
		ArrayList<String> sol4;
		ArrayList<String> sol3;
		ArrayList<String> sol10 = recFind(s,root,10);

		
		if(sol10 == null) { //If no 10 digit combo is found
			sol7 = recFind(s,root,7);
			if(sol7 == null) { //If no 7 digit combo is found
				sol4 = recFind(s,root,4);
				sol3 = recFind(s,root,3);
				if(sol4 == null && sol3 == null) { //If no 3-4 digit combo is found
					System.out.println(s); //Maybe format this later
				} else if(sol3 == null) { //If no 3 digit combo is found
					printSol(sol3,s);
				} else if(sol4 == null) { //If no 4 digit combo is found
					printSol(sol4,s);
				}
				else {
					printSol(sol4,sol3);
				}
			} else {
				printSol(sol7,s);
			}
		} else {
			printSol(sol10,s);
		}
	}
	
	/**
	 * Operates from 0 to d
	 * @param s
	 * @param n
	 * @param d
	 * @return
	 */
	private ArrayList<String> recFind(String s, Node n, int d) {
		if(d == 0) {
			return n.getData();
		} else {
			for(int i = 0; i < n.getChildren().size(); i++) {
				if(s.charAt(s.length()-d) == n.getChildren().get(i).getIndex()) {
					recFind(s,n.getChildren().get(i),d-1);
				}
			}
			return null;
		}
	}
	
	public void add(String s) {
		recAdd(s,root,0);
	}
	
	private void recAdd(String s, Node n, int d) {
		if(s.length() == 1) {
			n.getData().add(s);
		} else {
			for(int i = 0; i < n.getChildren().size(); i++) {
				//Checks all children for match
				if(toNum(s.charAt(d)) == n.getChildren().get(i).getIndex()) {
					recAdd(s,n.getChildren().get(i),d+1);
				}
			}
			//If there isn't a child, we make one
			Node tNode = new Node(null,toNum(s.charAt(d)));
			n.addChild(tNode);
			recAdd(s,tNode,d+1);
		}
	}
	
	private String stringToNum(String s) {
		String solution = "";
		for(int i = 0; i < s.length(); i++) {
			solution += toNum(s.charAt(i));
		}
		return solution;
	}
	
	/**
	 * Converts from a letter into the number representation based
	 * on the international standard of number/letter mapping
	 * @param c - the character to be mapped to the integer
	 * @return int - the number associated with each letter
	 */
	private int toNum(char c) {
		switch(c) {
		case 'a': return 2;
		case 'b': return 2;
		case 'c': return 2;
		case 'd': return 3;
		case 'e': return 3;
		case 'f': return 3;
		case 'g': return 4;
		case 'h': return 4;
		case 'i': return 4;
		case 'j': return 5;
		case 'k': return 5;
		case 'l': return 5;
		case 'm': return 6;
		case 'n': return 6;
		case 'o': return 6;
		case 'p': return 7;
		case 'q': return 7;
		case 'r': return 7;
		case 's': return 7;
		case 't': return 8;
		case 'u': return 8;
		case 'v': return 8;
		case 'w': return 9;
		case 'x': return 9;
		case 'y': return 9;
		case 'z': return 9;
		default: return -1;	//Shouldn't happen
		}
	}
	
	private String formatPhoneNum(String n) {
		return n.substring(0,3) + n.substring(4,6) + n.substring(7);
	}
	
	/** Finds all permutations of the words and prints each
	 * 
	 * @param s1
	 */
	private void printSol(ArrayList<String> s1, String num) {
		String num1, num2;
		num1 = num;
		if(s1.get(0).length() == 10) {
			for(int i = 0; i < s1.size(); i++) {
				System.out.println(s1.get(i));
			}
		} else if(s1.get(0).length() == 7) {
			num1 = num1.substring(0,3);
			for(int i = 0; i < s1.size(); i++) {
				System.out.printf("%s-%s-%s",num1,s1.get(i));
			}
		} else if(s1.get(0).length() == 4) {
			num1 = num1.substring(0,6);
			for(int i = 0; i < s1.size(); i++) {
				System.out.printf("%s-%s-%s",num1.substring(0,3),
						num1.substring(3,6),s1.get(i));
			}
		} else {
			num2 = num1.substring(6);
			num1 = num1.substring(0,3);
			
			for(int i = 0; i < s1.size(); i ++) {
				System.out.printf("%s-%s-%s",num1,s1.get(i),num2);
			}
		}
	}
	
	/** Finds all permutations of the words and prints each
	 * 
	 * @param s1
	 */
	private void printSol(ArrayList<String> s1, ArrayList<String> s2) {
		for(int i = 0; i < s1.size(); i++) {
			for(int j = 0; j < s2.size(); j++) {
				for(int k = 0; k < s2.size(); k++) {
					System.out.printf("%s-%s-%s",s2.get(k),
							s2.get(j),s1.get(i));
				}
			}
		}
	}
	
}
