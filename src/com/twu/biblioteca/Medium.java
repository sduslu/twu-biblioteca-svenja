package com.twu.biblioteca;

public abstract class Medium {

    protected boolean available;
    protected String title;

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return this.title;
    }

    public abstract String toString();

}
