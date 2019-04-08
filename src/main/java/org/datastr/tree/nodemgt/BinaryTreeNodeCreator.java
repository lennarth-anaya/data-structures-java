package org.datastr.tree.nodemgt;

import org.datastr.tree.BinaryTreeNode;

@FunctionalInterface
public interface BinaryTreeNodeCreator<V extends Comparable<V>> {
    BinaryTreeNode<V> createNewNode(V value);
}
