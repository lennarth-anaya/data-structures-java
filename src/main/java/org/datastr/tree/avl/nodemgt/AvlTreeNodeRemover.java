package org.datastr.tree.avl.nodemgt;

import org.datastr.tree.BinaryTreeNode;
import org.datastr.tree.avl.AvlTreeNode;
import org.datastr.tree.nodemgt.BinaryTreeNodeRemover;

/**
 * @author Lennarth Anaya
 *
 * This class has a very specific, clear and
 * narrowed concern but it is not intended to
 * be used by API clients. hence its visibility
 * is not public.
 *
 * @param <V> type of the elements the Tree can contain.
 */
class AvlTreeNodeRemover<V extends Comparable<V>>
    extends BinaryTreeNodeRemover<V>
{
    private AvlNodeHeightCalculator<V> calculator = new AvlNodeHeightCalculator<>();
    private AvlSubtreeBalancer<V> balancer = new AvlSubtreeBalancer<V>();

    /**
     * This method reuses Binary Tree insertion base behavior, it balances nodes
     * (and the Tree itself) and keeps their height up to date.
     */
    @Override
    protected <N extends BinaryTreeNode<V>> N recursiveRemove(N node, V value) {
        AvlTreeNode<V> avlNode = (AvlTreeNode<V>) node;

        avlNode = super.recursiveRemove(avlNode, value);

        calculator.updateHeight(avlNode);

        avlNode = balancer.balance(avlNode, value);

        return (N) avlNode;
   }
}
