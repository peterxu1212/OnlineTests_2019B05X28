package com.acquisio.basic.java.question02;

class Node {
    String name;
    Node children[];

    public Node(String name, Node... children) {
        this.name = name;
        if (children != null) {
            this.children = new Node[children.length];
            System.arraycopy(
                    children, 0, this.children, 0, children.length);
        }
    }
    
    public void PrintNode(String strDepth) {    	
    	
    	System.out.println(strDepth + this.name);    	
    	if (children != null) {    		
    		for (int i = 0; i < children.length; i++) {    			
    			Node childNode = children[i];
    			if (childNode != null) {    				
    				childNode.PrintNode(strDepth + "..");
    			}    			    			
    		}    		
    	}    	
    }
}


