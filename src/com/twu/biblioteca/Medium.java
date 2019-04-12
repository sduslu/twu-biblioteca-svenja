package com.twu.biblioteca;

public abstract class Medium {

    protected boolean available;

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract String toString();

}
