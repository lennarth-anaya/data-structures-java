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
public class AvlTreeRemovalTest {
    private AvlTreeNodeRemover<Integer> remover = new AvlTreeNodeRemover<Integer>();
    private PreOrderTreeTraverser<Integer> traverser = new PreOrderTreeTraverser<>();

    final StringBuilder strBuilder = new StringBuilder();

    /**
     * Builds:
     *
     *      (2)
     *   /---|---\
     * (1)       (4)
     *        /---|---\
     *      (3)       (5)
     */
    protected AvlTreeNode<Integer> build5ItemsInsertedInAscOrderAvlTree() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(2);
        root.setLeft(new AvlTreeNode<>(1));
        root.setRight(new AvlTreeNode<>(4));
        root.getRight().setLeft(new AvlTreeNode<>(3));
        root.getRight().setRight(new AvlTreeNode<>(5));

	return root;
    }

    /**
     * Builds:
     *
     *           (4)
     *        /---|---\
     *       (2)      (5)
     *    /---|---\
     *  (1)      (3)
     */
    protected AvlTreeNode<Integer> build5ItemsInsertedInDescOrderAvlTree() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(4);
        root.setLeft(new AvlTreeNode<>(2));
        root.getLeft().setLeft(new AvlTreeNode<>(1));
        root.getLeft().setRight(new AvlTreeNode<>(3));
        root.setRight(new AvlTreeNode<>(5));

        return root;
    }

    @Test
    public void removeLeafTest() {
        AvlTreeNode<Integer> root = build5ItemsInsertedInAscOrderAvlTree();

        root = remover.remove(root, 3);

	// check tree was left as expected
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("2, 1, 4, 5, ", strBuilder.toString());
    }
    
    @Test
    public void removeNodeWithTwoLeavesTest() {
        AvlTreeNode<Integer> root = build5ItemsInsertedInAscOrderAvlTree();

        root = remover.remove(root, 4);

        // check tree was left as expected
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("2, 1, 3, 5, ", strBuilder.toString());
    }

    @Test
    public void removeRootTest() {
        AvlTreeNode<Integer> root = build5ItemsInsertedInAscOrderAvlTree();

        root = remover.remove(root, 2);

        // check tree was left as expected
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("3, 1, 4, 5, ", strBuilder.toString());
        assertEquals(2, root.getHeight());
    }

    @Test
    public void removalRightRotationsTest() {
        AvlTreeNode<Integer> root = build5ItemsInsertedInAscOrderAvlTree();
   
	// not a real test's assertion, but helps to figure out how the tree is changing
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("2, 1, 4, 3, 5, ", strBuilder.toString());

        // Start testing it, unbalance tree on the left
        root = remover.remove(root, 1);

	// check tree was left as expected
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("3, 2, 4, 5, ", strBuilder.toString());
        assertEquals(2, root.getHeight());

	// unbalance it again
	root = remover.remove(root, 2);

	// check tree was left as expected
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("4, 3, 5, ", strBuilder.toString());
        assertEquals(1, root.getHeight());
    }

    @Test
    public void removalLeftRotationsTest() {
	AvlTreeNode<Integer> root = build5ItemsInsertedInDescOrderAvlTree();

        // not a real test's assertion, but helps to figure out how the tree is changing
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("4, 2, 1, 3, 5, ", strBuilder.toString());

        // Start testing it, unbalance tree on the right
        root = remover.remove(root, 5);

	// check tree was left as expected
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("3, 2, 1, 4, ", strBuilder.toString());
        assertEquals(2, root.getHeight());

        // unbalance it again
        root = remover.remove(root, 4);

        // check tree was left as expected
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("2, 1, 3, ", strBuilder.toString());
        assertEquals(1, root.getHeight());
    }

}
