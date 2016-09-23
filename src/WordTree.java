
public class WordTree<T> {
	private Node<String> root;

	public WordTree() {
		this.root = new Node<String>();
	}
	
	/**
	 * Returns the wordified number
	 * @return
	 */
	public String method1(String n) {
//		n = formatPhoneNum(n);
		Node<String> tNode = root;
//		int tInt;
//		for(int i = 0; i < n.length(); i++) {
//			for(int j = 0; j < tNode.getChildren().size(); j++) {
//				tInt = tNode.getChildren().get(j).getIndex();
//				if((int)n.charAt(i)-47 == tInt) {
//					tNode = tNode.getChildren().get(j);
//				} else if(j == tNode.getChildren().size() -1) {
//					return null;
//				}
//			}
//		}
		return tNode.getData();
		
		//looks for 10 char word, returns if found
		//looks for 7 char word minus the area code, returns if found
		//looks for separate 3 char and 4 char word for exchange and number
		//returns whatever this last search finds.
		
		//needs to return an array of options for some other method to make 
		//all combinations from.
	}
	
	public void add(String s) {
		String tStr = stringToNum(s);
		Node<String> tNode = root;
		int tInt;	// Used to store the temporary index the 
					// algorithm is looking for
		
		// Iterates through the letters of the input string
		for(int i = 0; i < tStr.length(); i++) {
			tInt = Integer.parseInt(tStr.substring(i, i+1));
			// Iterates through the children of the current node
			for(int j = 0; j < tNode.getChildren().size(); j++) {
				// If the node has a child with the appropriate index
				// that node is moved to
				if(tInt == tNode.getChildren().get(j).getIndex()) {
					tNode = tNode.getChildren().get(j);
					break;
				// If there is no node, the node is made
				} else if(j == tNode.getChildren().size()-1) {
					if(i == tStr.length()-1) {
						tNode.addChild(new Node<String>(s,tInt));
					} else {
						tNode.addChild(new Node<String>("",tInt));
					}
				}
			}
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
}
