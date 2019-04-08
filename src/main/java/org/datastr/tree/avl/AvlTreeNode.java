package org.datastr.tree.avl;

import org.datastr.tree.BinaryTreeNode;

public class AvlTreeNode<V extends Comparable<V>>
    implements BinaryTreeNode<V>
{
    private V value;
    
    private long height;
    private AvlTreeNode<V> left;
    private AvlTreeNode<V> right;
    
    public AvlTreeNode(V value) {
        this.value = value;
        height = 0;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }
    
    @Override
    public V getValue() {
        return value;
    }

    @Override
    public AvlTreeNode<V> getLeft() {
        return left;
    }

    @Override
    public AvlTreeNode<V> getRight() {
        return right;
    }

    @Override
    public <N extends BinaryTreeNode<V>> void setLeft(N left) {
        // only AvlTreeNodes supported, throw ClassCastException otherwise
        this.left = (AvlTreeNode<V>) left;
    }

    @Override
    public <N extends BinaryTreeNode<V>> void setRight(N right) {
        // only AvlTreeNodes supported, throw ClassCastException otherwise
        this.right = (AvlTreeNode<V>) right;
    }

}
