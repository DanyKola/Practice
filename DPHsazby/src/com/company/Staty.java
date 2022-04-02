package com.company;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Staty {

 //proměnné
    private String zkratkaStatu;//AT
    private String nazevStatu;//Austria
    private int plnaSazbaDPH;
    private double snizenaSazbaDPH;
    private boolean specialniDPH;

    public Staty(String zkratkaStatu, String nazevStatu, int plnaSazbaDPH, double snizenaSazbaDPH, boolean specialniDPH) {
        this.zkratkaStatu = zkratkaStatu;
        this.nazevStatu = nazevStatu;
        this.plnaSazbaDPH = plnaSazbaDPH;
        this.snizenaSazbaDPH = snizenaSazbaDPH;
        this.specialniDPH = specialniDPH;
    }

    public String getZkratkaStatu() {
        return zkratkaStatu;
    }

    public void setZkratkaStatu(String zkratkaStatu) {
        this.zkratkaStatu = zkratkaStatu;
    }

    public String getNazevStatu() {
        return nazevStatu;
    }

    public void setNazevStatu(String nazevStatu) {
        this.nazevStatu = nazevStatu;
    }

    public int getPlnaSazbaDPH() {
        return plnaSazbaDPH;
    }

    public void setPlnaSazbaDPH(int plnaSazbaDPH) {
        this.plnaSazbaDPH = plnaSazbaDPH;
    }

    public double getSnizenaSazbaDPH() {
        return snizenaSazbaDPH;
    }

    public void setSnizenaSazbaDPH(double snizenaSazbaDPH) {
        this.snizenaSazbaDPH = snizenaSazbaDPH;
    }

    public boolean isSpecialniDPH() {
        return specialniDPH;
    }

    public void setSpecialniDPH(boolean specialniDPH) {
        this.specialniDPH = specialniDPH;
    }

    @Override
    public String toString() {
        return zkratkaStatu + " " + nazevStatu + " " + plnaSazbaDPH +" "+ snizenaSazbaDPH +" "+ specialniDPH;
    }






}
