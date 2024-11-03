package com.gildedrose;

public class Item {

    public Name name;

    public SellIn sellIn;

    public Quality quality;

    public Item(Name name, SellIn sellIn, Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
