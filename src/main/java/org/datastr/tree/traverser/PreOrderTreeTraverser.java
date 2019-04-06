package org.datastr.tree.traverser;

import org.datastr.tree.BinaryTreeNode;
import org.datastr.visitor.DataVisitor;

public class PreOrderTreeTraverser<V extends Comparable<V>>
	implements TreeTraverser<V>
{
	@Override
	public void traverse(BinaryTreeNode<V> node, DataVisitor<V> visitor) {
		if (node != null) {
			visitor.visited(node);
		}

		if (node.getLeft() != null) {
			traverse(node.getLeft(), visitor);
		}

		if (node.getRight() != null) {
			traverse(node.getRight(), visitor);
		}
	}
}
