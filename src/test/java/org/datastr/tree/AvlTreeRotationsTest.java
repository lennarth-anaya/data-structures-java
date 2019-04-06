package org.datastr.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.datastr.tree.avl.BinaryTreeRotator;
import org.junit.Test;

/**
 * 
 * @author Lennarth Anaya
 *
 */
public class AvlTreeRotationsTest extends BSTreeTests {
	@Test
	public void leftRotationHappyPath() {
		BinaryTreeRotator<String> rotator = new BinaryTreeRotator<>();
		
		BinaryTreeNode<String> root = getTreeRoot();
		
		BinaryTreeNode<String> rotated = rotator.rotateLeft(root);
		assertEquals("J", rotated.getValue());
		
		assertEquals("F", rotated.getLeft().getValue());
		assertEquals("D", rotated.getLeft().getLeft().getValue());
		assertEquals("G", rotated.getLeft().getRight().getValue());
		
		assertEquals("K", rotated.getRight().getValue());
	}
	
	@Test
	public void rotationNull() {
		BinaryTreeRotator<String> rotator = new BinaryTreeRotator<>();
		BinaryTreeNode<String> rotated = rotator.rotateLeft(null);
		assertNull(rotated);
		
		rotated = rotator.rotateRight(null);
		assertNull(rotated);
	}

	@Test
	public void leftRotationPenultimateNode() {
		BinaryTreeRotator<String> rotator = new BinaryTreeRotator<>();
		
		BinaryTreeNode<String> root = getTreeRoot();
		
		BinaryTreeNode<String> rotated = rotator.rotateLeft(root.getLeft().getLeft());
		assertEquals("C", rotated.getValue());
		assertEquals("B", rotated.getLeft().getValue());
		assertEquals("A", rotated.getLeft().getLeft().getValue());
		assertNull(rotated.getLeft().getRight());
	}
	
	@Test
	public void leftRotationNoRotation() {
		BinaryTreeRotator<String> rotator = new BinaryTreeRotator<>();
		
		BinaryTreeNode<String> root = getTreeRoot();
		
		BinaryTreeNode<String> rotated = rotator.rotateLeft(
				root.getRight().getLeft().getRight());
		assertEquals("I", rotated.getValue());
		assertEquals("H", rotated.getLeft().getValue());
		assertNull(rotated.getRight());
	}
	
	@Test
	public void leftRotationLeaf() {
		BinaryTreeRotator<String> rotator = new BinaryTreeRotator<>();
		
		BinaryTreeNode<String> root = getTreeRoot();
		
		BinaryTreeNode<String> rotated = rotator.rotateLeft(
				root.getRight().getRight());
		assertEquals("K", rotated.getValue());
		assertNull(rotated.getLeft());
		assertNull(rotated.getRight());
	}
	
	@Test
	public void rightRotationHappyPath() {
		BinaryTreeRotator<String> rotator = new BinaryTreeRotator<>();
		
		BinaryTreeNode<String> root = getTreeRoot();
		
		BinaryTreeNode<String> rotated = rotator.rotateRight(root);
		assertEquals("D", rotated.getValue());
		
		assertEquals("F", rotated.getRight().getValue());
		assertEquals("E", rotated.getRight().getLeft().getValue());
		assertEquals("J", rotated.getRight().getRight().getValue());
		
		assertEquals("B", rotated.getLeft().getValue());
	}
	
	@Test
	public void rightRotationPenultimateNode() {
		BinaryTreeRotator<String> rotator = new BinaryTreeRotator<>();
		
		BinaryTreeNode<String> root = getTreeRoot();
		
		BinaryTreeNode<String> rotated = rotator.rotateRight(root.getLeft().getLeft());
		assertEquals("A", rotated.getValue());
		assertEquals("B", rotated.getRight().getValue());
		assertEquals("C", rotated.getRight().getRight().getValue());
		assertNull(rotated.getRight().getLeft());
	}
	
	@Test
	public void rightRotationNoRotation() {
		BinaryTreeRotator<String> rotator = new BinaryTreeRotator<>();
		
		BinaryTreeNode<String> root = getTreeRoot();
		
		BinaryTreeNode<String> rotated = rotator.rotateRight(
				root.getRight().getLeft());
		assertEquals("G", rotated.getValue());
		assertEquals("I", rotated.getRight().getValue());
		assertNull(rotated.getLeft());
	}
	
	@Test
	public void rightRotationLeaf() {
		BinaryTreeRotator<String> rotator = new BinaryTreeRotator<>();
		
		BinaryTreeNode<String> root = getTreeRoot();
		
		BinaryTreeNode<String> rotated = rotator.rotateRight(
				root.getRight().getRight());
		assertEquals("K", rotated.getValue());
		assertNull(rotated.getLeft());
		assertNull(rotated.getRight());
	}
}
