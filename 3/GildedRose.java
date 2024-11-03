package com.gildedrose;

class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    private boolean isEligibleForQualityIncrease(Item item) {
        return (isAgedBrie(item) || isBackstagePass(item)) && item.quality.value < 50;
    }
    private boolean isAgedBrie(Item item) {
        return new Name("Aged Brie").equals(item.name);
    }
    private boolean isBackstagePass(Item item) {
        return new Name("Backstage passes to a TAFKAL80ETC concert").equals(item.name);
    }    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	HowDoINameIt(items[i]);
        }
    }
    public void HowDoINameIt(Item item) {
    	Case1(item);
    	Case2(item);
    	Case3(item);
    	Case4(item);
    }   
    public void Case1(Item item) {
    	if (!item.name.equals(new Name("Aged Brie")) && item.quality.value > 0 && !item.name.equals(new Name("Sulfuras, Hand of Ragnaros")) //!item.name.equals(new Name("Aged Brie"))
                && !item.name.equals(new Name("Backstage passes to a TAFKAL80ETC concert")))
    	{
    		item.quality--;           
        }
    }
    public void Case2(Item item) {
        if (!isEligibleForQualityIncrease(item)) return;
        item.quality++;
        if (isBackstagePass(item) && (item.sellIn.value < 11 || item.sellIn.value < 6)) {
        	item.quality++;  // Additional increase if conditions are met
        }
    }  
    public void Case3(Item item) {
        if (!item.name.equals(new Name("Sulfuras, Hand of Ragnaros"))) {
            item.sellIn--;
        }
    }  
    public void Case4(Item item) {
        if (item.sellIn.value >= 0) {
            return;
        }
        if (item.name.equals(new Name("Aged Brie")) && item.quality.value < 50) {
        	item.quality++; 
            return;
        }
        Case4_1(item);
    }  
    public void Case4_1(Item item) {
        if (item.name.equals(new Name("Backstage passes to a TAFKAL80ETC concert"))) { 
        	item.quality = 0;
            return;
        }
        if (item.quality.value > 0 && !item.name.equals(new Name("Sulfuras, Hand of Ragnaros"))) {
        	item.quality++; 
        }
    }
}