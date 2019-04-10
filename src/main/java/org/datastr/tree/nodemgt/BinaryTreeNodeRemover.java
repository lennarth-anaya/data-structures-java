package org.datastr.tree.nodemgt;

import org.datastr.tree.BinaryTreeNode;
import org.datastr.tree.lookup.MaxNodeTreeLookup;

/**
 * @author Lennarth Anaya
 *
 * This class has a very specific, clear and
 * narrowed concern but it is not intended to
 * be used by API clients. hence its visibility
 * is not public.
 *
 * @param <V> type the elements the Tree can contain.
 */
public class BinaryTreeNodeRemover<V extends Comparable<V>>
{
    private MaxNodeTreeLookup<V> maxFinder = new MaxNodeTreeLookup<>();

    public <N extends BinaryTreeNode<V>> N remove(N node, V value) {
        if (value == null || node == null) {
            return node;
        }
        
        return recursiveRemove(node, value);
    }
    
    /**
     * Method above hae some restrictions we don't want to
     * have on every single recursion.
     */
    protected <N extends BinaryTreeNode<V>> N recursiveRemove(N node, V value) {
	final ThreadLocal<N> replacementNode = new ThreadLocal<>();
        int valueComparison = value.compareTo(node.getValue());

	if (valueComparison == 0) {
	    // we've found the item to remove, replace it with null in recursion
	    if (node.getLeft() == null && node.getRight() == null){
		// no leaves, safe to remove
                return null;
	    } else if (node.getLeft() != null && node.getRight() == null) {
		// only left leaf, safe to just link that one
                return node.getLeft();
	    } else if (node.getLeft() == null && node.getRight() != null) {
		// only right leaf, safe to jut link that one
                return node.getRight();
	    } else {
                // substitute node (could be with max on the left or min on the right, using former)
		maxFinder.traverse(node.getLeft(), iNode -> replacementNode.set((N) iNode));
		
                N updatedLeft = recursiveRemove(node.getLeft(), replacementNode.get().getValue());

		// don't lose right branch from node about to be replaced (safe op since we found max node on left)
		replacementNode.get().setRight(node.getRight());
                // replacementNode is now diplicate, let's remove reference from previous position
                replacementNode.get().setLeft(updatedLeft);
               
                System.out.println("DEBUG b " + replacementNode.get().getValue());
		System.out.println("DEBUG c " + replacementNode.get().getLeft());
		System.out.println("DEBUG d " + replacementNode.get().getRight().getValue());
                System.out.println("DEBUG e " + replacementNode.get().getRight().getLeft().getValue());
		System.out.println("DEBUG f " + replacementNode.get().getRight().getRight().getValue());

                return replacementNode.get();
	    }
	} else if (valueComparison < 0) {
            if (node.getLeft() == null) {
                // item was not found
                // logger.warn("Item [" + value + "] was not found on the tree");
                return node;
            } else {
                // keep looking on the left
                node.setLeft(recursiveRemove(node.getLeft(), value));
            }
        } else {
            if (node.getRight() == null) {
                // item was not found
		// logger.warn("Item [" + value + "] was not found on the tree");
                return node;
            } else {
                // keep looking on the right
                node.setRight(recursiveRemove(node.getRight(), value));
            }
        }
        
        return node;
    }

}
