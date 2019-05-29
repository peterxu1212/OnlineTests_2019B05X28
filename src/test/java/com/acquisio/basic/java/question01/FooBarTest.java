package com.acquisio.basic.java.question01;

import org.junit.Test;
import static org.junit.Assert.*;


public class FooBarTest {

	
    @Test
    public void testFooBar3() {		
		
        assertEquals("Foo", new FooBar().fooBar(3));
		//assertFalse("Foo" != new FooBar().fooBar(3));
    }
	
	@Test
    public void testFooBar4() {		
		
        assertEquals("4", new FooBar().fooBar(4));		
    }
	
	@Test
    public void testFooBar5() {		
		
        assertEquals("Bar", new FooBar().fooBar(5));		
    }
	
	@Test
    public void testFooBar15() {		
		
        assertEquals("Bar Foo", new FooBar().fooBar(15));		
    }
	


}