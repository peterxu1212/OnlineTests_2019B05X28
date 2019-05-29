package com.acquisio.basic.java.question02;

/**
 * QUESTION 2: TreeNode
 * Using the tree structure define at
 * http://en.wikipedia.org/wiki/File:Binary_tree.svg,
 * add the code necessary to optain the following output.
 * ..2
 * ....7
 * ......2
 * ......6
 * ........5
 * ........11
 * ....5
 * ......9
 * ........4
 *
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */
public class TreeNavigation {

    public static void main(String[] args) {
        TreeNavigation main = new TreeNavigation();
        main.treeNode();
    }

    private void treeNode() {

        // TODO: Implement code here
		Node n_level_4_a = new Node("5", null, null);
        Node n_level_4_b = new Node("11", null, null);
        Node n_level_4_c = new Node("4", null, null);		
		
		Node n_level_3_a = new Node("2", null, null);
        Node n_level_3_b = new Node("6", n_level_4_a, n_level_4_b);
        Node n_level_3_c = new Node("9", n_level_4_c, null);
        
        Node n_level_2_a = new Node("7", n_level_3_a, n_level_3_b);
        Node n_level_2_b = new Node("5", null, n_level_3_c);
        
        Node n_level_1 = new Node("2", n_level_2_a, n_level_2_b);
        
        
        n_level_1.PrintNode("..");
		
		/*  
		
		the output is as following:
		
			..2
			....7
			......2
			......6
			........5
			........11
			....5
			......9
			........4

		
		*/
		
		
    }
}
