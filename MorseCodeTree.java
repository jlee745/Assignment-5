/**
 * The MorseCodeTree class encapsulates a binary tree structure specifically 
 * for translating Morse code into English letters. 
 * It adheres to the LinkedConverterTreeInterface and includes functionalities for 
 * constructing the tree, inserting nodes, retrieving data, and executing various tree traversals.
 * 
 * @param <String> the type of the data stored in the tree nodes
 * 
 *  LinkedConverterTreeInterface
 *  treeNode
 *  java.util.ArrayList
 * 
 * @author Jaagyoon Lee
 * 
 */
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;
	
	/**
     * Constructs a MorseCodeTree and builds the tree.
     */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
     * Gets the root of the Morse code tree.
     * 
     * @return the root TreeNode of the Morse code tree.
     */

	@Override
	public TreeNode getRoot() {
		return root;
	}

	/**
     * Sets the root of the Morse code tree.
     * 
     * @param newNode the new root TreeNode to be set.
     */
	@Override
	public void setRoot(TreeNode newNode) {
		root = newNode;
	}

	/**
     * Inserts a letter into the Morse code tree based on the provided Morse code.
     * 
     * @param code   the Morse code representing the position of the letter in the tree.
     * @param result the letter to be inserted in the tree.
     */
	@Override
	public void insert(String code, String result) {
		addNode(root, code, result);
		
	}

	/**
     * Adds a node to the Morse code tree based on the provided Morse code.
     * 
     * @param root   the current root of the subtree where the node will be added.
     * @param code   the Morse code representing the position of the letter in the tree.
     * @param letter the letter to be inserted in the tree.
     */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length() == 1) {
	        if (code.equals(".")) {
	            root.setLeftChild(new TreeNode<>(letter));
	        } else if (code.equals("-")) {
	            root.setRightChild(new TreeNode<>(letter));
	        }
	    } else {
	        char direction = code.charAt(0);
	        if (direction == '.') {
	            if (root.getLeftChild() == null) {
	                root.setLeftChild(new TreeNode<>(null));
	            }
	            addNode(root.getLeftChild(), code.substring(1), letter);
	        } else if (direction == '-') {
	            if (root.getRightChild() == null) {
	                root.setRightChild(new TreeNode<>(null));
	            }
	            addNode(root.getRightChild(), code.substring(1), letter);
	        }
	    }
	}

	/**
     * Fetches a letter from the Morse code tree based on the provided Morse code.
     * 
     * @param code the Morse code representing the position of the letter in the tree.
     * @return the letter fetched from the tree.
     */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
     * Recursively fetches a letter from the Morse code tree based on the provided Morse code.
     * 
     * @param root the current root of the subtree where the letter will be fetched from.
     * @param code the Morse code representing the position of the letter in the tree.
     * @return the letter fetched from the tree.
     */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (code.length() == 0) {
            return root.getData();
        } else {
            char direction = code.charAt(0);
            if (direction == '.') {
                return fetchNode(root.getLeftChild(), code.substring(1));
            } else if (direction == '-') {
                return fetchNode(root.getRightChild(), code.substring(1));
            }
        }
        return null;
	}

	 /**
     * Unsupported operation to delete a node from the Morse code tree.
     * 
     * @param data the data to be deleted.
     * @return nothing, as this operation is unsupported.
     * @throws UnsupportedOperationException if the method is called.
     */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
     * Unsupported operation to update the Morse code tree.
     * 
     * @return nothing, as this operation is unsupported.
     * @throws UnsupportedOperationException if the method is called.
     */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
     * Builds the Morse code tree by inserting letters at their respective Morse code positions.
     */
	@Override
	public void buildTree() {
		root = new TreeNode<>("");

        
        insert(".", "e");
        insert("-", "t");

      
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");

        
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");

       
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
        insert("-.-.", "c");
		
	}

	/**
     * Converts the Morse code tree to an ArrayList containing the data in LNR (in-order) traversal order.
     * 
     * @return an ArrayList containing the data in LNR order.
     */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
	}

	/**
     * Performs an LNR (in-order) traversal of the Morse code tree and adds the data to the provided list.
     * 
     * @param root the current root of the subtree to be traversed.
     * @param list the list to store the data in LNR order.
     */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
            LNRoutputTraversal(root.getLeftChild(), list);
            list.add(root.getData());
            LNRoutputTraversal(root.getRightChild(), list);
        }
		
	}

}