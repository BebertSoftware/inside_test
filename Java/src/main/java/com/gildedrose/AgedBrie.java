package com.gildedrose;

public class AgedBrie extends StandardItem {

	public AgedBrie(int sellIn, int quality) {
		super("Aged Brie", sellIn, quality);
	}

	/**
	 * Aged brie improves day after day.
	 */
	@Override
	public void updateQuality() {
		if (this.sellIn < 0) {
			this.quality = this.quality + 2;
		} else {
			this.quality = this.quality + 1;
		}
		if (this.quality > MAX_QUALITY) {
			this.quality = MAX_QUALITY;
		} 
	}

}
