package org.datastr.visitor;

import org.datastr.tree.BinaryTreeNode;

/**
 * 
 * @author Lennarth Anaya
 *
 * @param <V> Elements type the Tree can contain.
 */
public interface DataVisitor<V extends Comparable<V>> {
	void visited(BinaryTreeNode<V> node);
}
