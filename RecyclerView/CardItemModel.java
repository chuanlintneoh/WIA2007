package com.example.drawerlayout2;



public class CardItemModel {
    String itemName;
    String itemNumber;
    int image;

    public CardItemModel(String itemName, String itemNumber, int image) {
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public int getImage() {
        return image;
    }
}

