package org.datastr.tree;

public class BinaryTreeNodeSimple<
       V extends Comparable<V>
    >
    implements BinaryTreeNode<V>
{
    private V value;
    private BinaryTreeNodeSimple<V> left;
    private BinaryTreeNodeSimple<V> right;
    
    public BinaryTreeNodeSimple(V value) {
        this.value = value;
    }
    
    @Override
    public V getValue() {
        return value;
    }

    @Override
    public BinaryTreeNodeSimple<V> getLeft() {
        return left;
    }

    @Override
    public <N extends BinaryTreeNode<V>> void setLeft(N left) {
        // java compiler forces to do next annoying cast
        this.left = (BinaryTreeNodeSimple<V>) left;
    }

    @Override
    public BinaryTreeNodeSimple<V> getRight() {
        return right;
    }

    @Override
    public <N extends BinaryTreeNode<V>> void setRight(N right) {
        // java compiler forces to do next annoying cast
        this.right = (BinaryTreeNodeSimple<V>) right;
    }

}
