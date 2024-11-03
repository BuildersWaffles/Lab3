package com.gildedrose;

public class Name {
    private final String value;

    public Name(String value) {
        this.value = value;
    }

    public boolean equals(Name other) {
        return this.value.equals(other.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
