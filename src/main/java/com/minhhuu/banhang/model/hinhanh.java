package com.minhhuu.banhang.model;
public class hinhanh {
    String url;

    public hinhanh(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "hinhanh{" +
                "url='" + url + '\'' +
                '}';
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public hinhanh(){}
}
