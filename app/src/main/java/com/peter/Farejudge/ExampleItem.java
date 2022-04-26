package com.peter.Farejudge;

public class ExampleItem {
    private String name;
    private String review;
    private String service;

    public ExampleItem(String name, String service, String review) {
        this.name = name;
        this.service = service;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
