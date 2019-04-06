package org.datastr.visitor;

import org.datastr.tree.BinaryTreeNode;

public interface DataVisitor<V extends Comparable<V>> {
	void visited(BinaryTreeNode<V> node);
}
