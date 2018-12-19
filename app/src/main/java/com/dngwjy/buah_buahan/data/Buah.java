package com.dngwjy.buah_buahan.data;

public class Buah {
String buah,description;
int gambar;

    public Buah(String buah, String description,int gambar) {
        this.buah = buah;
        this.gambar = gambar;
        this.description=description;
    }

    public String getBuah() {
        return buah;
    }

    public void setBuah(String buah) {
        this.buah = buah;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
