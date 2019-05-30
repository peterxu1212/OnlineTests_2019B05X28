package com.acquisio.basic.java.question03;

/**
 * QUESTION 04: StackOverflow
 * This program crashes after throwing StackOverflowError exception:
 * Fix the factorial method.
 *
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */
 
//ant run-utility-q3 -Dutility=IssueResolving
 
public class IssueResolving {
    public static void main(String[] args) {
        IssueResolving instance = new IssueResolving();
        System.out.println(instance.factorial(7));
    }

    int factorial(int n) {
        // TODO: Fix code here.
        int result = 0;        
        if (n == 1) {
        	result = 1;
        }
        else {        	
        	result = factorial(n - 1) * n;
        }        
        
        return result;
    }

}
