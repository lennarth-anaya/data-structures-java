package org.datastr.tree;

/**
 * 
 * @author Lennarth Anaya
 * 
 * Many of structures algorithms use basic minimal
 * abstract type.
 * 
 *
 * @param <V>
 */
public interface BinaryTreeNode<V extends Comparable<V>>
{
	V getValue();
	
	<N extends BinaryTreeNode<V>> N getLeft();
	<N extends BinaryTreeNode<V>> void setLeft(N left);
	
	<N extends BinaryTreeNode<V>> N getRight();
	<N extends BinaryTreeNode<V>> void setRight(N right);
}
