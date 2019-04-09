package org.datastr.tree.traverser;

import org.datastr.tree.BinaryTreeNode;
import org.datastr.visitor.DataVisitor;

/**
 * 
 * @author Lennarth Anaya
 *
 * @param <V> Elements type the Tree can contain.
 */
@FunctionalInterface
public interface TreeTraverser<V extends Comparable<V>> {
	<N extends BinaryTreeNode<V>> void traverse(N treeNode, DataVisitor<N> visitor);
}
