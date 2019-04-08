package org.datastr.tree;

import org.junit.Before;

/**
 * 
 * @author Lennarth Anaya
 *
 */
public class BSTreeTests {
	private BinaryTreeNode<String> root;
	
	public BinaryTreeNode<String> getTreeRoot() {
		return root;
	}

	/**
	 * Builds next tree:
	 * 
	 *            (F)
	 *             |
	 *         /--------\
	 *       (D)        (J)
	 *        |          |
	 *      /---\      /---\
	 *    (B)   (E)  (G)   (K)
	 *     |          |
	 *   /---\        --\
	 * (A)   (C)        (I)
	 *                   |
	 *                 /--
	 *               (H)
	 */
	@Before
	public void treeSetup() {
		root = new BinaryTreeNodeSimple<>("F");
		
		root.setLeft(new BinaryTreeNodeSimple<String>("D"));
		
		root.getLeft().setLeft(new BinaryTreeNodeSimple<String>("B"));
		root.getLeft().setRight(new BinaryTreeNodeSimple<String>("E"));
		
		root.getLeft().getLeft().setLeft(new BinaryTreeNodeSimple<String>("A"));
		root.getLeft().getLeft().setRight(new BinaryTreeNodeSimple<String>("C"));
		
		root.setRight(new BinaryTreeNodeSimple<String>("J"));
		root.getRight().setLeft(new BinaryTreeNodeSimple<String>("G"));
		root.getRight().getLeft().setRight(new BinaryTreeNodeSimple<String>("I"));
		root.getRight().getLeft().getRight().setLeft(new BinaryTreeNodeSimple<String>("H"));
		root.getRight().setRight(new BinaryTreeNodeSimple<String>("K"));
	}

}
