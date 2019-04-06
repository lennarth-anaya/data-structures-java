package org.datastr.tree.traverser;

import java.util.ArrayDeque;

import org.datastr.tree.BinaryTreeNode;
import org.datastr.visitor.DataVisitor;

public class LevelOrderTreeTraverser<V extends Comparable<V>>
	implements TreeTraverser<V>
{

	@Override
	public void traverse(BinaryTreeNode<V> treeNode, DataVisitor<V> visitor) {
		ArrayDeque<BinaryTreeNode<V>> nodesToVisit = new ArrayDeque<>();
		traverseByLevel(treeNode, visitor, nodesToVisit);
	}
	
	private void traverseByLevel(BinaryTreeNode<V> node,
		DataVisitor<V> visitor, ArrayDeque<BinaryTreeNode<V>> nodesToVisit)
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

	private void traverseUnvisited(ArrayDeque<BinaryTreeNode<V>> nodesToVisit,
		DataVisitor<V> visitor)
	{
		for(BinaryTreeNode<V> curNode = nodesToVisit.poll();
			curNode != null;
			curNode = nodesToVisit.poll()
		) {
			traverseByLevel(curNode, visitor, nodesToVisit);
		}
	}
}
