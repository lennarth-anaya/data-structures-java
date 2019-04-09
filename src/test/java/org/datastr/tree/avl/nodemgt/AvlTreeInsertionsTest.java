package org.datastr.tree.avl.nodemgt;

import static org.junit.Assert.assertEquals;

import org.datastr.tree.avl.AvlTreeNode;
import org.junit.Test;

import org.datastr.tree.traverser.PreOrderTreeTraverser;

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
    public void insertionUnbalancedRightTwoeLeaves() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(50);
        
        root = inserter.insert(root, 70);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(50), root.getValue());
        
        root = inserter.insert(root, 90);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(70), root.getValue());
    }
    
    @Test
    public void insertionUnbalancedRightWithLeftLeaf() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(50);
        
        root = inserter.insert(root, 70);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(50), root.getValue());
        
        root = inserter.insert(root, 60);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(60), root.getValue());
    }
    
    @Test
    public void insertionUnbalancedLeftTwoLeaves() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(50);
        
        root = inserter.insert(root, 20);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(50), root.getValue());
        
        root = inserter.insert(root, 10);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(20), root.getValue());
    }

    @Test
    public void insertionUnbalancedLeftWithRightLeaf() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(50);
        
        root = inserter.insert(root, 20);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(50), root.getValue());
        
        root = inserter.insert(root, 30);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(30), root.getValue());
    }

    @Test
    public void insertionStressed() {
        final StringBuilder strBuilder = new StringBuilder();
        PreOrderTreeTraverser<Integer> traverser = new PreOrderTreeTraverser<>();

        AvlTreeNode<Integer> root = new AvlTreeNode<>(50);

        root = inserter.insert(root, 20);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(50), root.getValue());

        root = inserter.insert(root, 30);
        assertEquals(1, root.getHeight());
        assertEquals(Integer.valueOf(30), root.getValue());

        root = inserter.insert(root, 25);
        assertEquals(2, root.getHeight());
        root = inserter.insert(root, 35);
        assertEquals(2, root.getHeight());
        assertEquals(Integer.valueOf(30), root.getValue());

        root = inserter.insert(root, 10);
        assertEquals(2, root.getHeight());
        root = inserter.insert(root, 65);
        assertEquals(2, root.getHeight());
        assertEquals(Integer.valueOf(30), root.getValue());

        // TEST UNBALANCING TREE TO THE RIGHT
        root = inserter.insert(root, 75);
        assertEquals(3, root.getHeight());
        root = inserter.insert(root, 70);
        assertEquals(3, root.getHeight());
        root = inserter.insert(root, 85);
        assertEquals(3, root.getHeight());

        //    tree's root right node must have been balanced (it was 50 before insertion)
        assertEquals(Integer.valueOf(70), root.getRight().getValue());
        //    tree's root should remain the same
        assertEquals(Integer.valueOf(30), root.getValue());
	
        root = inserter.insert(root, 90);
        assertEquals(3, root.getHeight());
        root = inserter.insert(root, 91);
        assertEquals(3, root.getHeight());

        //    this time, former tree's root 30 should have been swapped with 70
        assertEquals(Integer.valueOf(70), root.getValue());

        //    let's check the whole tree so far
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("70, 30, 20, 10, 25, 50, 35, 65, 85, 75, 90, 91, ", strBuilder.toString());


        // TEST UNBALANCING TREE TO THE LEFT
        root = inserter.insert(root, 13);
        assertEquals(4, root.getHeight());
        root = inserter.insert(root, 11);
        assertEquals(4, root.getHeight());
        //    next insertion provokes one of the most interesting AVL rotation scenarios:
        root = inserter.insert(root, 15);
        assertEquals(4, root.getHeight());

        //    check whole tree current state
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("70, 30, 13, 11, 10, 20, 15, 25, 50, 35, 65, 85, 75, 90, 91, ", strBuilder.toString());

        root = inserter.insert(root, 66);
        root = inserter.insert(root, 14);
        assertEquals(4, root.getHeight());
        //    root node has been swapped again to 30
        assertEquals(Integer.valueOf(30), root.getValue());
	
        //    check the whole final tree
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        System.out.println("FINAL DEBUG " + strBuilder.toString());
        assertEquals("30, 13, 11, 10, 20, 15, 14, 25, 70, 50, 35, 65, 66, 85, 75, 90, 91, ", strBuilder.toString());
    }

}
