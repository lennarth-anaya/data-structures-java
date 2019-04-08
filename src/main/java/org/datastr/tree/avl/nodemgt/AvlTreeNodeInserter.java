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
     * Method above has some restrictions we don't want to
     * have on every single recursion.
     */
    @Override
    protected <N extends BinaryTreeNode<V>> N recursiveInsert(
        N node, V value
    ) {
        AvlTreeNode<V> ref = (AvlTreeNode<V>) node;
        AvlTreeNode<V> resultSubRoot = super.recursiveInsert(ref, value);
        
        calculator.updateHeight(resultSubRoot);
        
        resultSubRoot = balancer.balance(resultSubRoot, value);
        
        // dirty Java's Generics:
        return (N) resultSubRoot;
    }
    
}