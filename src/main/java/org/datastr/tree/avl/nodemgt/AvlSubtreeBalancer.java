package org.datastr.tree.avl.nodemgt;

import org.datastr.tree.avl.AvlTreeNode;

public class AvlSubtreeBalancer<V extends Comparable<V>> {
    // avoiding IoC to simplify and focus on algorithm
    private AvlTreeRotator<V> rotator = new AvlTreeRotator<>();
    private AvlNodeHeightCalculator<V> calculator = new AvlNodeHeightCalculator<>();
    
    public AvlTreeNode<V> balance(AvlTreeNode<V> ref, V value) {
        AvlTreeNode<V> balancedRoot;
        
        AvlTreeNode<V> left = ref.getLeft();
        AvlTreeNode<V> right = ref.getRight();
        
        AvlTreeImbalance imbalance = calculator.calculateImbalance(ref);
        
        switch(imbalance) {
        case LEFT_UNBALANCED:
            if (value.compareTo(left.getValue()) < 0) {
                balancedRoot = balanceDoubleLeftLeaves(ref);
            } else {
                balancedRoot = balanceLeftWithRightLeaf(ref);
            }
            
            break;
        case RIGHT_UNBALANCED:
            if (value.compareTo(left.getValue()) > 0) {
                balancedRoot = balanceDoubleRightLeaves(ref);
            } else {
                balancedRoot = balanceRightWithLeftLeaf(ref);
            }
            
            break;
        default:
            balancedRoot = ref;
        }
        
        return balancedRoot;
    }

    private AvlTreeNode<V> balanceRightWithLeftLeaf(AvlTreeNode<V> node) {
        AvlTreeNode<V> rotatedNewSubRoot = rotator.rotateRight(node.getRight());
        node.setRight(rotatedNewSubRoot);
        
        // rightRotTmp concides with last rotation root, no need to reassign it
        rotator.rotateLeft(node);
        
        // upate height of both involved nodes
        calculator.updateHeight(node);
        calculator.updateHeight(rotatedNewSubRoot);
        
        return rotatedNewSubRoot;
    }

    private AvlTreeNode<V> balanceDoubleRightLeaves(AvlTreeNode<V> node) {
        AvlTreeNode<V> rotatedNewSubRoot = rotator.rotateLeft(node);
        
        // upate height of both involved nodes
        calculator.updateHeight(node);
        calculator.updateHeight(rotatedNewSubRoot);
        
        return rotatedNewSubRoot;
    }

    private AvlTreeNode<V> balanceLeftWithRightLeaf(AvlTreeNode<V> node) {
        AvlTreeNode<V> rotatedNewSubRoot = rotator.rotateLeft(node.getLeft());
        
        node.setLeft(rotatedNewSubRoot);
        rotator.rotateRight(node);
        
        // upate height of both involved nodes
        calculator.updateHeight(node);
        calculator.updateHeight(rotatedNewSubRoot);
        
        return rotatedNewSubRoot;
    }

    private AvlTreeNode<V> balanceDoubleLeftLeaves(AvlTreeNode<V> node) {
        AvlTreeNode<V> rotatedNewSubRoot = rotator.rotateRight(node);
        
        // upate height of both involved nodes
        calculator.updateHeight(node);
        calculator.updateHeight(rotatedNewSubRoot);
        
        return rotatedNewSubRoot;
    }
}
