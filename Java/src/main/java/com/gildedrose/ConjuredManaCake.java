package com.gildedrose;

public class ConjuredManaCake extends StandardItem {

	public ConjuredManaCake(int sellIn, int quality) {
		super("Conjured Mana Cake", sellIn, quality);
	}

	/**
	 * "Conjured" items degrade in Quality twice as fast as normal items.
	 */
	@Override
	public void updateQuality() {
		this.quality = this.quality - 2;
		if (this.quality < MIN_QUALITY) {
			this.quality = MIN_QUALITY;
		}
	}
}
