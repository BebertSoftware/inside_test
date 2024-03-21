package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	@Test
	void testStandardItem() {
		StandardItem[] items = new StandardItem[] { new StandardItem("+5 Dexterity Vest", 5, 7), new StandardItem("Elixir of the Mongoose", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(4, items[0].sellIn, "sellIn should decrease");
		assertEquals(6, items[0].quality, "quality should decrease");

		assertEquals(-1, items[1].sellIn, "sellIn should decrease");
		assertEquals(0, items[1].quality, "quality should be 0 (MIN)");
	}

	@Test
	void testAgedBrie() {
		StandardItem[] items = new StandardItem[] { new AgedBrie(4, 6), new AgedBrie(0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(3, items[0].sellIn, "sellIn should decrease");
		assertEquals(7, items[0].quality, "quality should increase");

		assertEquals(-1, items[1].sellIn, "sellIn should decrease");
		assertEquals(2, items[1].quality, "quality should increase twice as fast if negative sellIn");
	}

	@Test
	void testSulfuras() {
		StandardItem[] items = new StandardItem[] { new Sulfuras(0, 80), new Sulfuras(-1, 80) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(0, items[0].sellIn, "never has to be sold ");
		assertEquals(80, items[0].quality, "never  decreases in Quality");

		assertEquals(-1, items[1].sellIn, "never has to be sold e");
		assertEquals(80, items[1].quality, "never  decreases in Quality");
	}
	
	@Test
	void testBackstagePass() {
		StandardItem[] items = new StandardItem[] { new BackstagePass(15, 20), new BackstagePass(10, 49), new BackstagePass(5, 21) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(14, items[0].sellIn, "TODO message");
		assertEquals(21, items[0].quality, "");

		assertEquals(9, items[1].sellIn, "");
		assertEquals(50, items[1].quality, "");
		
		assertEquals(4, items[2].sellIn, "");
		assertEquals(24, items[2].quality, "");
	}
	
	@Test
	void testConjuredManaCake() {
		StandardItem[] items = new StandardItem[] { new ConjuredManaCake(15, 20) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(14, items[0].sellIn, "TODO message");
		assertEquals(18, items[0].quality, "");

	}
}
