package com.gildedrose;

public class GildedRose {
	/**
	 * We are using StandardItems instead of Items.
	 */
    private StandardItem[] items;

    public GildedRose(StandardItem[] items) {
        this.items = items;
    }

	public void updateQuality() {
		// standard items manage their own update logic
		for (int i = 0; i < items.length; i++) {
			items[i].updateSellIn();
			items[i].updateQuality();
		}
	}
}
