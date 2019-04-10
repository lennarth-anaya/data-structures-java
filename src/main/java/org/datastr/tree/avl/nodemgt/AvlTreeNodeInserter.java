package org.datastr.tree.avl.nodemgt;

import org.datastr.tree.BinaryTreeNode;
import org.datastr.tree.avl.AvlTreeNode;
import org.datastr.tree.nodemgt.BinaryTreeNodeInserter;


/**
 * @author Lennarth Anaya
 *
 * This class has a very specific, clear and
 * narrowed concern but it is not intended to
 * be used by API clients. hence its visibility
 * is not public.
 *
 * @param <V> Elements type the Tree can contain.
 */
class AvlTreeNodeInserter<V extends Comparable<V>>
    extends BinaryTreeNodeInserter<V>
{
    private AvlNodeHeightCalculator<V> calculator = new AvlNodeHeightCalculator<>();
    private AvlSubtreeBalancer<V> balancer = new AvlSubtreeBalancer<V>();
    
    public AvlTreeNodeInserter() {
        super((value) -> new AvlTreeNode<>(value));
    }
    
    /**
     * This method reuses Binary Tree insertion base behavior, it balances nodes
     * (and the Tree itself) and keeps their height up to date.
     */
    @Override
    protected <N extends BinaryTreeNode<V>> N recursiveInsert(
        N node, V value
    ) {
        AvlTreeNode<V> ref = (AvlTreeNode<V>) node;

        ref = super.recursiveInsert(ref, value);

        calculator.updateHeight(ref);
        
        ref = balancer.balance(ref, value);
       
        // dirty Java's Generics:
        return (N) ref;
    }
    
}
