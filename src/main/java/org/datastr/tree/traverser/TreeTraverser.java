package org.datastr.tree.traverser;

import org.datastr.tree.BinaryTreeNode;
import org.datastr.visitor.DataVisitor;

@FunctionalInterface
public interface TreeTraverser<V extends Comparable<V>> {
	void traverse(BinaryTreeNode<V> treeNode, DataVisitor<V> visitor);
}
