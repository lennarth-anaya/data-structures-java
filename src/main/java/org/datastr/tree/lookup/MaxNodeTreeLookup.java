package org.datastr.tree.lookup;

import org.datastr.tree.BinaryTreeNode;
import org.datastr.tree.traverser.TreeTraverser;
import org.datastr.visitor.DataVisitor;

/**
 * 
 * @author Lennarth Anaya
 *
 * @param <V> Elements type the Tree can contain.
 */
public class MaxNodeTreeLookup<V extends Comparable<V>>
	implements TreeTraverser<V>
{
	@Override
	public <N extends BinaryTreeNode<V>> void traverse(N node, DataVisitor<N> visitor) {
		if (node.getRight() != null) {
			traverse(node.getRight(), visitor);
		} else {
			visitor.visited(node);
		}
	}
}
