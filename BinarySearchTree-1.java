
public class BinarySearchTree<E extends Comparable<E>> {
	private TreeNode<E> node; 
	/**
	 * 
	 * @return
	 */
	public boolean hasLeft() {
		if (node.getData()<node.getParent().getData()) {
			return true; 
		}
		else {
			return false;
		} 
	}
	/**
	 * 
	 * @return
	 */
	public boolean hasRight() {
		if (node.getData()>node.getParent().getData()) {
			return true; 
		}
		else {
			return false;
		} 
	}
	/**
	 * 
	 * @return
	 */
	public boolean isLeaf() {
		if (node.hasRight()==false && node.hasLeft==false){
			return false;
		}
	}
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (node.getData=null){
			return false;
		}
		else{
			return true;
		}
	}
	/**
	 * 
	 * @return
	 */
	public boolean isRoot() {
		if (node.getParent=null){
			return true;
		}
		else{
			return false;
		}
		
	}
	/**
	 * 
	 * @return
	 */
	public boolean isLeftChild() {
		if (node.getParent.getData>node.getData){
			return true;
		}
		else{
		return false;
		}
	}
	/**
	 * 
	 * @return
	 */
	public boolean isRightChild() {
		if (node.getParent.getData<node.getData){
			return true;
		}
		else{
		return false;
		}
	}
	/**
	 * 
	 * @return
	 */
	public boolean hasParent() { 
		return false;
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> findNode(E e) {
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public BinarySearchTree<E> findMin() {
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public BinarySearchTree<E> findSuccessor() {
		return null;
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> addRoot(E e) {
		return this;
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> insert(E e) {
		return this;
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> search(E e) {
		return null;
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> delete(E e) {
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public int size() {
		return -1;
	}
	/**
	 * 
	 * @return
	 */
	public int balanceFactor() {
		return 0;
	}
	/**
	 * 
	 * @return
	 */
	public int height() {
		return -1;
	}
	/**
	 * 
	 * @return
	 */
	public int depth() {
		return -1;
	}
	/**
	 * 
	 */
	public void balance() {

	}
	/**
	 * 
	 */
	public void rightRotation() {

	}
	/**
	 * 
	 */
	public void leftRotation() {

	}
	/**
	 * 
	 */
	public void printPostorder() {

	}
}
