public class TreeNode<E extends Comparable<E>>{ 
	private E data; 
	private TreeNode<E> left; 
	private TreeNode<E> right; 
	private TreeNode<E> parent; 
	private TreeNode<E> balanceFactor;

	public TreeNode (E data){
		this.data=data; 
		this.left=null; 
		this.right=null; 
		this.parent=null; 
		this.balanceFactor=null;
	} 
	public E getData(){ 
		return data; 
	} 
	public void setData(E data){ 
		this.data=data;
	}
	public TreeNode<E> getLeft(){
		return left;
	}
	public void setLeft(TreeNode<E> left){
		this.left=left;
	}
	public TreeNode<E> getRight(){ 
		return right;
	}
	public void setRight(TreeNode <E> right){ 
		this.right=right;
	}
	public TreeNode<E> getParent(){
		return parent;
	}
	public void setParent(TreeNode<E> parent){
		this.parent=parent;
	} 
	public TreeNode<E> getBalanceFactor(){ 
		return balanceFactor;
	}
	public void setBalanceFactor(TreeNode<E> balanceFactor){ 
		this.balanceFactor=balanceFactor; 
	}
}