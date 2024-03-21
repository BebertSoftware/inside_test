package com.gildedrose;

public class Sulfuras extends StandardItem {

	public Sulfuras(int sellIn, int quality) {
		super("Sulfuras, Hand of Ragnaros", sellIn, quality);
	}

	@Override
	public void updateQuality() {
		// "Sulfuras", being a legendary item, never decreases in Quality
	}

	@Override
	public void updateSellIn() {
		// "Sulfuras", being a legendary item, never has to be sold
	}
}
