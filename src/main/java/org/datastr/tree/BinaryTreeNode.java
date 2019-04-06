package org.datastr.tree;

public class BinaryTreeNode<V extends Comparable<V>> {
	private V value;
	private BinaryTreeNode<V> left;
	private BinaryTreeNode<V> right;

	public BinaryTreeNode(V value) {
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}
	
	public BinaryTreeNode<V> getLeft() {
		return left;
	}
	
	public void setLeft(BinaryTreeNode<V> left) {
		this.left = left;
	}
	
	public BinaryTreeNode<V> getRight() {
		return right;
	}
	
	public void setRight(BinaryTreeNode<V> right) {
		this.right = right;
	}
	
}
