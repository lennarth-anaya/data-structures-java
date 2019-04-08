package org.datastr.tree.avl.nodemgt;

import static org.junit.Assert.assertEquals;

import org.datastr.tree.avl.AvlTreeNode;
import org.junit.Test;

/**
 * 
 * @author Lennarth Anaya
 *        
 *         
 * First nodes are created manually since we're not testing
 * a Tree container object itself but isolated operation.
 */
public class AvlTreeInsertionsTest {
    private AvlTreeNodeInserter<Integer> inserter = new AvlTreeNodeInserter<Integer>();
    
    @Test
    public void insertionBalancedRightTwoeLeaves() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(50);
        
        root = inserter.insert(root, 70);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(50), root.getValue());
        
        root = inserter.insert(root, 90);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(70), root.getValue());
    }
    
    @Test
    public void insertionBalancedRightWithLeftLeaf() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(50);
        
        root = inserter.insert(root, 70);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(50), root.getValue());
        
        root = inserter.insert(root, 60);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(60), root.getValue());
    }
    
    @Test
    public void insertionBalancedLeftTwoeLeaves() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(50);
        
        root = inserter.insert(root, 20);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(50), root.getValue());
        
        root = inserter.insert(root, 10);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(20), root.getValue());
    }

    @Test
    public void insertionBalancedLeftWithRightLeaf() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(50);
        
        root = inserter.insert(root, 20);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(50), root.getValue());
        
        root = inserter.insert(root, 30);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(30), root.getValue());
    }

}
