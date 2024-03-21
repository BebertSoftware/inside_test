package com.gildedrose;

/**
 * An item which can be updated. IMPORTANT NOTE : if the goblin can
 * modify the Item class at will, we should opt for a composite class (loose
 * coupling) rather than inheritance (tight coupling). We may not believe the
 * goblin.
 * 
 */
public class StandardItem extends Item implements UpdatableItem {

	public static final int MIN_QUALITY = 0;
	public static final int MAX_QUALITY = 50;

	public StandardItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	/**
	 * A standard item has its quality decreasing each day until 0.
	 * Once the sell by date has passed, Quality degrades twice as fast.
	 * 
	 */
	@Override
	public void updateQuality() {
		if (this.sellIn < 0) {
			this.quality = this.quality - 2;
		} else {
			this.quality = this.quality - 1;
		}
		if (this.quality < MIN_QUALITY) {
			this.quality = MIN_QUALITY;
		} 
	}

	/**
	 * Can be negative.
	 */
	@Override
	public void updateSellIn() {
		this.sellIn = this.sellIn - 1;
	}

}
