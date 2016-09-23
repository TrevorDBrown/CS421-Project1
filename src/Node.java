import java.util.ArrayList;

public class Node<T> {
	private int index;
	private T data;
	private ArrayList<Node<T>> children;
	
	/**
	 * Constructor for the root of the WordTree
	 */
	public Node() {
		this.index = 0;
		data = null;
		children = new ArrayList<Node<T>>();
	}

	/**
	 * Constructor for all leaf Nodes of the WordTree
	 * @param data
	 * @param index
	 */
	public Node(T data, int index) {
		this.index = index;
		this.data = data;
		children = new ArrayList<Node<T>>();
	}
	
	public void addChild(Node<T> n) {
		children.add(n);
	}

	/**
	 * Returns the arraylist of children of the node
	 */
	public ArrayList<Node<T>> getChildren() {
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
	public T getData() {
		return data;
	}

}
