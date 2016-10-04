import java.util.ArrayList;

public class Node {
	private int index;
	private ArrayList<String> data;
	private ArrayList<Node> children;
	
	/**
	 * Constructor for the root of the WordTree
	 */
	public Node() {
		this.index = 0;
		data = null;
		children = new ArrayList<Node>();
	}

	/**
	 * Constructor for all leaf Nodes of the WordTree
	 * @param data
	 * @param index
	 */
	public Node(ArrayList<String> data, int index) {
		this.index = index;
		this.data = data;
		children = new ArrayList<Node>();
	}
	
	public void addChild(Node n) {
		children.add(n);
	}

	/**
	 * Returns the arraylist of children of the node
	 */
	public ArrayList<Node> getChildren() {
		return children;
		
	}
	
	/**
	 * Returns the index
	 * @return
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Returns the data
	 * @return
	 */
	public ArrayList<String> getData() {
		return data;
	}

}
