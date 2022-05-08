package com.example.android01.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Proudect {
    private String id;
    private String name;
    private double price;
    private boolean isAvailable;
    private String imageUrl;

    public Proudect(String id, String name, double price, boolean isAvailable, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "Proudect{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proudect proudect = (Proudect) o;
        return Double.compare(proudect.getPrice(), getPrice()) == 0 &&
                isAvailable() == proudect.isAvailable() &&
                getId().equals(proudect.getId()) &&
                getName().equals(proudect.getName()) &&
                getImageUrl().equals(proudect.getImageUrl());
    }


    public static DiffUtil.ItemCallback<Proudect> itemCallback = new DiffUtil.ItemCallback<Proudect>() {
        @Override
        public boolean areItemsTheSame(@NonNull Proudect oldItem, @NonNull Proudect newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Proudect oldItem, @NonNull Proudect newItem) {
            return oldItem.equals(newItem);
        }


    };


}


