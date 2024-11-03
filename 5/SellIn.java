package com.gildedrose;

public class SellIn {
    public int value;  

    public SellIn(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
