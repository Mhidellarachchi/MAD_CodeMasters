package com.example.manufestfile;

public class ToDo {
    private int id;
    private String catagory, period, price, count;
    private long started;

    public ToDo() {

    }

    public ToDo(int id, String catagory, String period, String price, String count, long started) {
        this.id = id;
        this.catagory = catagory;
        this.period = period;
        this.price = price;
        this.count = count;
        this.started = started;

    }

    public ToDo(String catagory, String period, String price, String count, long started) {
        this.catagory = catagory;
        this.period = period;
        this.price = price;
        this.count = count;
        this.started = started;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }


}