package org.datastr.tree.nodemgt;

import org.datastr.tree.BinaryTreeNode;

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
public class BinaryTreeNodeInserter<V extends Comparable<V>>
{
    private BinaryTreeNodeCreator<V> nodeCreator;
    
    public BinaryTreeNodeInserter(BinaryTreeNodeCreator<V> nodeCreator) {
        this.nodeCreator = nodeCreator;
    }
    
    public <N extends BinaryTreeNode<V>> N insert(N ref, V value) {
        if (value == null || ref == null) {
            return ref;
        }
        
        return recursiveInsert(ref, value);
    }
    
    /**
     * Method above hae some restrictions we don't want to
     * have on every single recursion.
     */
    protected <N extends BinaryTreeNode<V>> N recursiveInsert(N ref, V value) {
        if (value.compareTo(ref.getValue()) < 0) {
            if (ref.getLeft() == null) {
                // we found its position
                ref.setLeft(nodeCreator.createNewNode(value));
            } else {
                // keep looking on the left
                ref.setLeft(recursiveInsert(ref.getLeft(), value));
            }
        } else {
            if (ref.getRight() == null) {
                // we found its position
                ref.setRight(nodeCreator.createNewNode(value));
            } else {
                // keep looking on the right
                ref.setRight(recursiveInsert(ref.getRight(), value));
            }
        }
        
        return ref;
    }

}
