package org.datastr.tree.avl.nodemgt;

import org.datastr.tree.BinaryTreeNode;

/**
 * 
 * @author Lennarth Anaya
 *
 * @param <V> Elements type the Tree can contain.
 */
public class AvlTreeRotator<V extends Comparable<V>> {
	public <N extends BinaryTreeNode<V>> N rotateLeft(N node) {
		N newRoot;
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
	
	public <N extends BinaryTreeNode<V>> N rotateRight(N node) {
		N newRoot;
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
