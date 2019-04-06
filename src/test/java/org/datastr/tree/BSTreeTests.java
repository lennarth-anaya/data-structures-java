package org.datastr.tree;

import org.junit.Before;

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
		root = new BinaryTreeNode<>("F");
		
		root.setLeft(new BinaryTreeNode<String>("D"));
		
		root.getLeft().setLeft(new BinaryTreeNode<String>("B"));
		root.getLeft().setRight(new BinaryTreeNode<String>("E"));
		
		root.getLeft().getLeft().setLeft(new BinaryTreeNode<String>("A"));
		root.getLeft().getLeft().setRight(new BinaryTreeNode<String>("C"));
		
		root.setRight(new BinaryTreeNode<String>("J"));
		root.getRight().setLeft(new BinaryTreeNode<String>("G"));
		root.getRight().getLeft().setRight(new BinaryTreeNode<String>("I"));
		root.getRight().getLeft().getRight().setLeft(new BinaryTreeNode<String>("H"));
		root.getRight().setRight(new BinaryTreeNode<String>("K"));
	}

}
