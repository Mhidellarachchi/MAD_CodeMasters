package com.example.delivaryservice;
public class ToDo {
    private int id;
    private String title, description, price;
    private long started, finished;

    public ToDo(){

    }

    public ToDo(int id, String title, String description,String price,  long started, long finished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.started = started;
        this.finished = finished;
    }

    public ToDo(String title, String description,String price, long started, long finished) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.started = started;
        this.finished = finished;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}