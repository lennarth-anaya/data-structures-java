package org.datastr.tree.avl.nodemgt;

import org.datastr.tree.avl.AvlTreeNode;

/**
 * @author Lennarth Anaya
 *
 * This class handles AVL tree nodes balancing by coordinating nodes rotations
 * with Rotator. Rotator is agnostic of nodes' heights, so that is also handled
 * by this balancer.
 */
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
            if (value.compareTo(right.getValue()) > 0) {
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
        
	// upate height of both involved nodes (order matters)
        calculator.updateHeight(rotatedNewSubRoot.getRight());
        calculator.updateHeight(rotatedNewSubRoot);

        // rotated root concides with last rotation root, no need to reassign it
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
        
	// upate height of both involved nodes (order matters)
        calculator.updateHeight(rotatedNewSubRoot.getLeft());
        calculator.updateHeight(rotatedNewSubRoot);

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
