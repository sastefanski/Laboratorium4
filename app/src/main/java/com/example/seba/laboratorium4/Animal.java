package com.example.seba.laboratorium4;

import java.io.Serializable;

public class Animal implements Serializable {
    private int id;
    private String gatunek, kolor, opis;
    private float wielkość;

    public Animal(int _id, String gatunek, String kolor, String opis, float wielkość) {
        this.id = id;
        this.gatunek = gatunek;
        this.kolor = kolor;
        this.opis = opis;
        this.wielkość = wielkość;
    }


    public Animal(String string, String cursorString, float aFloat, String s) {
    }


    @Override
    public String toString() {
        return "Zwierze: [id=" + id + ", gatunek=" + gatunek + ", kolor=" + kolor + ", wielkość=" +wielkość+" ]";
    }


    public int getId() {
        return id;
    }

    public String getGatunek() {
        return gatunek;
    }

    public String getKolor() {
        return kolor;
    }

    public String getOpis() {
        return opis;
    }

    public float getWielkość() {
        return wielkość;
    }

    public void setId(int id) {
        this.id = id;
    }
}


