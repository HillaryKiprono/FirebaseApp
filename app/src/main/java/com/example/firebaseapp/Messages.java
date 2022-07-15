package com.example.firebaseapp;

public class Messages {

    String foodName,foodPrice,foodQty,imageUrl;

    public Messages() {
    }

    public Messages(String foodName, String foodPrice, String foodQty, String imageUrl) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodQty = foodQty;
        this.imageUrl = imageUrl;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodQty() {
        return foodQty;
    }

    public void setFoodQty(String foodQty) {
        this.foodQty = foodQty;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
