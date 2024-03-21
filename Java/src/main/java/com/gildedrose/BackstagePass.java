package com.gildedrose;

public class BackstagePass extends StandardItem {

	public BackstagePass(int sellIn, int quality) {
		super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
	}

	/**
	 * "Backstage passes", like aged brie, increases in Quality as its SellIn value
	 * approaches; Quality increases by 2 when there are 10 days or less and by 3
	 * when there are 5 days or less but Quality drops to 0 after the concert.
	 * TODO  5 and 10 should be constants
	 */
	@Override
	public void updateQuality() {
		if (this.sellIn < 0) {
			this.quality = MIN_QUALITY;
		} else {
			if (this.sellIn < 5) {
				this.quality = this.quality + 3;
			} else if (this.sellIn < 10) {
				this.quality = this.quality + 2;
			} else {
				this.quality = this.quality + 1;
			}
			if (this.quality > MAX_QUALITY) {
				this.quality = MAX_QUALITY;
			}
		}
	}
}
