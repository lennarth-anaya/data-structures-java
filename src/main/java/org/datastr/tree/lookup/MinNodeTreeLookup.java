package org.datastr.tree.lookup;

import org.datastr.tree.BinaryTreeNode;
import org.datastr.tree.traverser.TreeTraverser;
import org.datastr.visitor.DataVisitor;

public class MinNodeTreeLookup<V extends Comparable<V>>
	implements TreeTraverser<V>
{
	@Override
	public void traverse(BinaryTreeNode<V> node, DataVisitor<V> visitor) {
		if (node.getLeft() != null) {
			traverse(node.getLeft(), visitor);
		} else {
			visitor.visited(node);
		}
	}
}
