package com.example.truyenii;

public class Truyen {
    private String TenTruyen;
    private String TheLoai;
    private int File;

    public Truyen( String tenTruyen, String theLoai, int file) {
        TenTruyen = tenTruyen;
        TheLoai = theLoai;
        File = file;
    }


    public String getTenTruyen() {
        return TenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        TenTruyen = tenTruyen;
    }

    public String getTheLoai() {return TheLoai; }

    public void setTheLoai(String theLoai) {TheLoai = theLoai; }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }
}
