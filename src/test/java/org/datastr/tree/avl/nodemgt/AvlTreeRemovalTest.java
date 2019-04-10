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
    protected AvlTreeNode<Integer> build5ItemsInsertedInOrderAvlTree() {
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
     *      (2)       (6)
     *   /---|---\   /-|-\
     * (1)       (3)(5)  (7)
     */
    protected AvlTreeNode<Integer> build6ItemsInsertedInOrderAvlTree() {
        AvlTreeNode<Integer> root = new AvlTreeNode<>(4);
        root.setLeft(new AvlTreeNode<>(2));
	root.getLeft().setLeft(new AvlTreeNode<>(1));
	root.getLeft().setRight(new AvlTreeNode<>(3));
        root.setRight(new AvlTreeNode<>(5));
        root.getRight().setRight(new AvlTreeNode<>(6));

        return root;
    }


    @Test
    public void removeLeafTest() {
        AvlTreeNode<Integer> root = build5ItemsInsertedInOrderAvlTree();

        root = remover.remove(root, 3);

	// check tree was left as expected
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("2, 1, 4, 5, ", strBuilder.toString());
    }
    
    @Test
    public void removeNodeWithTwoLeavesTest() {
        AvlTreeNode<Integer> root = build5ItemsInsertedInOrderAvlTree();

        root = remover.remove(root, 4);

        // check tree was left as expected
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("2, 1, 3, 5, ", strBuilder.toString());
    }

    @Test
    public void removeRootTest() {
        AvlTreeNode<Integer> root = build5ItemsInsertedInOrderAvlTree();

        root = remover.remove(root, 2);

        // check tree was left as expected
        strBuilder.setLength(0);
        traverser.traverse(root, node -> strBuilder.append(node.getValue() + ", "));
        assertEquals("3, 1, 4, 5, ", strBuilder.toString());
        assertEquals(2, root.getHeight());
    }

}
