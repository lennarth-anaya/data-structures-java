package org.datastr.tree.avl.nodemgt;

import org.datastr.tree.avl.AvlTreeNode;

public class AvlNodeHeightCalculator<V extends Comparable<V>> {
    public void updateHeight(AvlTreeNode<V> node) {
        node.setHeight(calculateHeight(node));
    }
    
    public long calculateHeight(AvlTreeNode<V> node) {
        if (node == null) {
            return -1;
        }
        
        long leftHeight = -1;
        AvlTreeNode<V> left = node.getLeft();
        if (left != null) {
            leftHeight = left.getHeight();
        }
        
        long rightHeight = -1;
        AvlTreeNode<V> right = node.getRight();
        if (right != null) {
            rightHeight = right.getHeight();
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public AvlTreeImbalance calculateImbalance(AvlTreeNode<V> node) {
        if (node == null) {
            return AvlTreeImbalance.BALANCED;
        }
        
        long leftHeight = calculateHeight(node.getLeft());
        long rightHeight = calculateHeight(node.getRight());
        
        int diff = (int) (leftHeight - rightHeight);
        
        if (Math.abs(diff) <= 1) {
            return AvlTreeImbalance.BALANCED;
        } else if (diff > 1) {
            return AvlTreeImbalance.LEFT_UNBALANCED;
        } else {
            return AvlTreeImbalance.RIGHT_UNBALANCED;
        }
    }
}
