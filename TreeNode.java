/**
 * A generalized TreeNode class designed to represent an individual node within a binary tree.
 *
 * @param <T> the type of the data stored in the node
 * @author Jaegyoon Lee
 */

public class TreeNode<T> {
	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	/**
     * Constructs a TreeNode with the specified data.
     *
     * @param dataNode / the data to be stored in the node
     */
	public TreeNode(T dataNode) {
		this.data = dataNode;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	/**
     * Constructs a deep copy of the specified TreeNode.
     *
     * @param node / the node to copy
     */
	public TreeNode(TreeNode<T> node) {
		this.data = node.getData();
        this.leftChild = (node.getLeftChild() != null) ? new TreeNode<>(node.getLeftChild()) : null;
        this.rightChild = (node.getRightChild() != null) ? new TreeNode<>(node.getRightChild()) : null;
	}
	
	/**
     * Returns the data stored in this node.
     *
     * @return the data stored in this node
     */
	public T getData() {
		return data;
	}
	
	/**
     * Returns the left child of this node.
     *
     * @return the left child of this node, or null if there is no left child
     */
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	/**
     * Sets the left child of this node.
     *
     * @param leftChild the node to be set as the left child
     */
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	
	/**
     * Returns the right child of this node.
     *
     * @return the right child of this node, or null if there is no right child
     */
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	
	/**
     * Sets the right child of this node.
     *
     * @param rightChild the node to be set as the right child
     */
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
}