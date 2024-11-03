package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public Quality quality;

    public Item(String name, int sellIn, Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
