package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private boolean canIncreaseQuality(Item item) {
        return (isAgedBrie(item) || isBackstagePass(item)) && item.quality.value < 50;
    }

    private boolean isAgedBrie(Item item) {
        return new Name("Aged Brie").equals(item.name);
    }

    private boolean isBackstagePass(Item item) {
        return new Name("Backstage passes to a TAFKAL80ETC concert").equals(item.name);
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        degradeRegularItemQuality(item);
        increaseQualityForSpecialItems(item);
        decreaseSellInValue(item);
        adjustQualityAfterSellIn(item);
    }

    private void degradeRegularItemQuality(Item item) {
        if (!isAgedBrie(item) && !isBackstagePass(item) && !isSulfuras(item) && item.quality.value > 0) {
            item.quality.value--;
        }
    }

    private void increaseQualityForSpecialItems(Item item) {
        if (!canIncreaseQuality(item)) return;
        
        item.quality.value++;

        if (!isBackstagePass(item)) return;

        if (item.sellIn.value < 6) {
            item.quality.value++;
            return;
        }

        if (item.sellIn.value < 11) {
            item.quality.value++; 
        }
    }

    private void decreaseSellInValue(Item item) {
        if (isSulfuras(item)) return;
        item.sellIn.value--;
    }

    private void adjustQualityAfterSellIn(Item item) {
        if (item.sellIn.value >= 0) return;
        
        if (isAgedBrie(item) && item.quality.value < 50) {
            item.quality.value++;
            return;
        }
        
        resetOrDegradeQuality(item);
    }

    private void resetOrDegradeQuality(Item item) {
        if (isBackstagePass(item)) {
            item.quality.value = 0;
            return;
        }
        
        if (item.quality.value > 0 && !isSulfuras(item)) {
            item.quality.value--;
        }
    }

    private boolean isSulfuras(Item item) {
        return new Name("Sulfuras, Hand of Ragnaros").equals(item.name);
    }
}