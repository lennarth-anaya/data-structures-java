package org.datastr.tree.avl;

import org.datastr.tree.BinaryTreeNode;

/**
 * 
 * @author Lennarth Anaya
 *
 * @param <V> Elements type the Tree can contain.
 */
public class BinaryTreeRotator<V extends Comparable<V>> {
	public BinaryTreeNode<V> rotateLeft(BinaryTreeNode<V> node) {
		BinaryTreeNode<V> newRoot;
		if (node == null) {
			newRoot = null;
		} else if (node.getRight() == null) {
			newRoot = node;
		} else {
			newRoot = node.getRight();
			node.setRight(newRoot.getLeft());
			newRoot.setLeft(node);
		}

		return newRoot;
	}
	
	public BinaryTreeNode<V> rotateRight(BinaryTreeNode<V> node) {
		BinaryTreeNode<V> newRoot;
		if (node == null) {
			newRoot = null;
		} else if (node.getLeft() == null) {
			newRoot = node;
		} else {
			newRoot = node.getLeft();
			node.setLeft(newRoot.getRight());
			newRoot.setRight(node);
		}

		return newRoot;
	}
}
