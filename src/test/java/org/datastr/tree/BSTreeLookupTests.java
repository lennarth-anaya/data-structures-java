package org.datastr.tree;

import static org.junit.Assert.assertEquals;

import org.datastr.tree.lookup.MaxNodeTreeLookup;
import org.datastr.tree.lookup.MinNodeTreeLookup;
import org.junit.Test;

public class BSTreeLookupTests extends BSTreeTests {
	@Test
	public void maxTraverse() {
		StringBuilder builder = new StringBuilder();
		MaxNodeTreeLookup<String> traverser = new MaxNodeTreeLookup<>();
		traverser.traverse(getTreeRoot(), node -> builder.append(node.getValue() + ", "));
		
		System.out.println(builder.toString());
		assertEquals("Traversal order should be",
				"K, ",
				builder.toString());
	}

	@Test
	public void minTraverse() {
		StringBuilder builder = new StringBuilder();
		MinNodeTreeLookup<String> traverser = new MinNodeTreeLookup<>();
		traverser.traverse(getTreeRoot(), node -> builder.append(node.getValue() + ", "));
		
		System.out.println(builder.toString());
		assertEquals("Traversal order should be",
				"A, ",
				builder.toString());
	}
}
