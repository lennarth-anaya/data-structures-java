package org.datastr.tree.traverser;

import java.util.ArrayDeque;

import org.datastr.tree.BinaryTreeNode;
import org.datastr.visitor.DataVisitor;

/**
 * 
 * @author Lennarth Anaya
 *
 * @param <V> Elements type the Tree can contain.
 */
public class LevelOrderTreeTraverser<V extends Comparable<V>>
	implements TreeTraverser<V>
{

	@Override
	public <N extends BinaryTreeNode<V>> void traverse(N treeNode, DataVisitor<N> visitor) {
		ArrayDeque<N> nodesToVisit = new ArrayDeque<>();
		traverseByLevel(treeNode, visitor, nodesToVisit);
	}
	
	private <N extends BinaryTreeNode<V>> void traverseByLevel(N node,
		DataVisitor<N> visitor, ArrayDeque<N> nodesToVisit)
	{
		visitor.visited(node);
		
		if (node.getLeft() != null) {
			nodesToVisit.addLast(node.getLeft());
		}
		
		if (node.getRight() != null) {
			nodesToVisit.addLast(node.getRight());
		}
		
		traverseUnvisited(nodesToVisit, visitor);
	}

	private <N extends BinaryTreeNode<V>> void traverseUnvisited(ArrayDeque<N> nodesToVisit,
		DataVisitor<N> visitor)
	{
		for(N curNode = nodesToVisit.poll();
			curNode != null;
			curNode = nodesToVisit.poll()
		) {
			traverseByLevel(curNode, visitor, nodesToVisit);
		}
	}
}
