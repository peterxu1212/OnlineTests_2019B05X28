package com.acquisio.basic.java.question07;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    // TODO: Insert your code here.	
	@Test
    public void testapplyOperationAdd() {		
		
        assertEquals(new Integer(3), new Calculator().applyOperation(1, 2, '+'));
    }
	
	@Test
    public void testapplyOperationMinus() {		
		
        assertEquals(new Integer(1), new Calculator().applyOperation(2, 1, '-'));		
    }
	
	@Test
    public void testapplyOperationMultiply() {		
		
        assertEquals(new Integer(6), new Calculator().applyOperation(2, 3, '*'));		
    }
	
	@Test
    public void testapplyOperationDivide() {		
		
        assertEquals(new Integer(4), new Calculator().applyOperation(8, 2, '/'));		
    }
	
	@Test
    public void testapplyOperationDivideByZero() {		
		
        assertEquals(null, new Calculator().applyOperation(7, 0, '/'));		
    }

	@Test(expected = IllegalArgumentException.class) 
	public void testapplyOperationUnsupported() { 
		new Calculator().applyOperation(7, 2, '|'); 
	}
	
}
