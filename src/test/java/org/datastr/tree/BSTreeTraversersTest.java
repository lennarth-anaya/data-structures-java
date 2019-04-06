package org.datastr.tree;

import static org.junit.Assert.assertEquals;

import org.datastr.tree.traverser.InOrderTreeTraverser;
import org.datastr.tree.traverser.LevelOrderTreeTraverser;
import org.datastr.tree.traverser.PostOrderTraverser;
import org.datastr.tree.traverser.PreOrderTreeTraverser;
import org.junit.Test;

public class BSTreeTraversersTest extends BSTreeTests {
	@Test
	public void byLevelTraverse() {
		StringBuilder builder = new StringBuilder();
		LevelOrderTreeTraverser<String> traverser = new LevelOrderTreeTraverser<>();
		traverser.traverse(getTreeRoot(), node -> builder.append(node.getValue() + ", "));
		
		System.out.println(builder.toString());
		assertEquals("Traversal order should be",
				"F, D, J, B, E, G, K, A, C, I, H, ",
				builder.toString());
	}
	
	@Test
	public void inOrderTraverse() {
		StringBuilder builder = new StringBuilder();
		InOrderTreeTraverser<String> traverser = new InOrderTreeTraverser<>();
		traverser.traverse(getTreeRoot(), node -> builder.append(node.getValue() + ", "));
		
		System.out.println(builder.toString());
		assertEquals("Traversal order should be",
				"A, B, C, D, E, F, G, H, I, J, K, ",
				builder.toString());
	}

	@Test
	public void preOrderTraverse() {
		StringBuilder builder = new StringBuilder();
		PreOrderTreeTraverser<String> traverser = new PreOrderTreeTraverser<>();
		traverser.traverse(getTreeRoot(), node -> builder.append(node.getValue() + ", "));
		
		System.out.println(builder.toString());
		assertEquals("Traversal order should be",
				"F, D, B, A, C, E, J, G, I, H, K, ",
				builder.toString());
	}
	
	@Test
	public void postOrderTraverse() {
		StringBuilder builder = new StringBuilder();
		PostOrderTraverser<String> traverser = new PostOrderTraverser<>();
		traverser.traverse(getTreeRoot(), node -> builder.append(node.getValue() + ", "));
		
		System.out.println(builder.toString());
		assertEquals("Traversal order should be",
				"A, C, B, E, D, H, I, G, K, J, F, ",
				builder.toString());
	}
	
}
