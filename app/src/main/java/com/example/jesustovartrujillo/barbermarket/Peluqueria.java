package com.example.jesustovartrujillo.barbermarket;

public class Peluqueria {

    private String mImageUrl;
    private String mName;

    public Peluqueria(String imageUrl, String name){
        this.mImageUrl = imageUrl;
        this.mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getName() {
        return mName;
    }

}
