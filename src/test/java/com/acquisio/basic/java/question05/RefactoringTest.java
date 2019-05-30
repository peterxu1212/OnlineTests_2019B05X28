package com.acquisio.basic.java.question05;

import static org.junit.Assert.*;

import org.junit.Test;

public class RefactoringTest {

    @Test
    public void testName() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        Refactoring app = new Refactoring(items);
        app.updateQuality();
		
        assertEquals("foo", app.items[0].name);
    }
	
	@Test
    public void testSellIn() {
        
		int i_sellin = 3;
		int i_quality = 20;
		
		Item[] items = new Item[]{new Item("foo", i_sellin, i_quality), new Item("Sulfuras, Hand of Ragnaros", i_sellin, i_quality)};
        Refactoring app = new Refactoring(items);
        app.updateQuality();
        
		//assertEquals("foo", app.items[0].name);
		
		assertEquals(i_sellin - 1, app.items[0].sellIn);
		
		assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].name);		
		assertEquals(i_sellin, app.items[1].sellIn);		
    }
	
	@Test
    public void testCaseSulfurasQuality() {
		
		int i_sellin = 3;
		
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", i_sellin, 80)};
        Refactoring app = new Refactoring(items);
        app.updateQuality();
		
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);	
		assertEquals(80, app.items[0].quality);
    }
	
	@Test
    public void testCaseAgedQuality() {		
		int i_sellin = 3;
		int i_quality_lt_50 = 48;
		int i_quality_e_50 = 50;
	
        Item[] items = new Item[]{new Item("Aged Brie", i_sellin, i_quality_lt_50), new Item("Aged Brie", i_sellin, i_quality_e_50)};
        Refactoring app = new Refactoring(items);
        app.updateQuality();
		
		assertEquals(i_quality_lt_50 + 1, app.items[0].quality);
	
		assertEquals(i_quality_e_50, app.items[1].quality);
    }
	
	@Test
    public void testCaseNormalQuality() {		
		int i_sellin_gt_0 = 3;
		
		int i_sellin_lt_0 = -1;
		
		int i_quality = 30;

	
        Item[] items = new Item[]{new Item("foo", i_sellin_gt_0, i_quality), new Item("foo", i_sellin_lt_0, i_quality)};
        Refactoring app = new Refactoring(items);
        app.updateQuality();
		
		assertEquals(i_quality - 1, app.items[0].quality);
		
		assertEquals(i_quality - 2, app.items[1].quality);
    }
	
	@Test
    public void testCaseConjuredQuality() {		
		int i_sellin_gt_0 = 6;
		
		int i_sellin_lt_0 = -1;
		
		int i_quality = 30;

	
        Item[] items = new Item[]{new Item("Conjured", i_sellin_gt_0, i_quality), new Item("Conjured", i_sellin_lt_0, i_quality)};
        Refactoring app = new Refactoring(items);
        app.updateQuality();
		
		assertEquals("Conjured", app.items[0].name);
		assertEquals(i_quality - 2, app.items[0].quality);
		
		assertEquals("Conjured", app.items[1].name);
		assertEquals(i_quality - 4, app.items[1].quality);
    }
	
	
	
	@Test
    public void testCaseBackstageQuality() {		
	
		int i_sellin_gt_10 = 14;
		int i_sellin_gt_5_lt_10 = 7;	
		int i_sellin_gt_0_lt_5 = 3;		
		int i_sellin_lt_0 = -1;
		
		int i_quality = 30;
	
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", i_sellin_lt_0, i_quality), 
		new Item("Backstage passes to a TAFKAL80ETC concert", i_sellin_gt_0_lt_5, i_quality),
		new Item("Backstage passes to a TAFKAL80ETC concert", i_sellin_gt_5_lt_10, i_quality),
		new Item("Backstage passes to a TAFKAL80ETC concert", i_sellin_gt_10, i_quality)};
		
        Refactoring app = new Refactoring(items);
        app.updateQuality();
		
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);		
		assertEquals(0, app.items[0].quality);
		
		assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);		
		assertEquals(i_quality + 3, app.items[1].quality);
		
		assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[2].name);		
		assertEquals(i_quality + 2, app.items[2].quality);
		
		assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[3].name);		
		assertEquals(i_quality + 1, app.items[3].quality);		

    }

}