package com.gildedrose;

public class Item {
    public Name name;
    public ItemAttributes attributes;

    public Item(Name name, SellIn sellIn, Quality quality) {
        this.name = name;
        this.attributes = new ItemAttributes(sellIn, quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.attributes.sellIn + ", " + this.attributes.quality;
    }
}

