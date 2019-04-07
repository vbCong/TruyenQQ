package com.example.truyenii;
import java.text.SimpleDateFormat;
public class Truyen {
//    private String TenTruyen;
//    private String TheLoai;
//    private int File;
//
//    public Truyen( String tenTruyen, String theLoai, int file) {
//        TenTruyen = tenTruyen;
//        TheLoai = theLoai;
//        File = file;
//    }
//
//
//    public String getTenTruyen() {
//        return TenTruyen;
//    }
//
//    public void setTenTruyen(String tenTruyen) {
//        TenTruyen = tenTruyen;
//    }
//
//    public String getTheLoai() {return TheLoai; }
//
//    public void setTheLoai(String theLoai) {TheLoai = theLoai; }
//
//    public int getFile() {
//        return File;
//    }
//
//    public void setFile(int file) {
//        File = file;
//    }
//}
    int IDT;
    int IDtl;
    String TenTruyen;
    int IDNguoiDung;
    String NgayDang;

    public Truyen(int IDT, int IDtl, int IDNguoiDung, String TenTruyen, String NgayDang){
        super();
        this.IDT = IDT;
        this.IDtl = IDtl;
        this.IDNguoiDung = IDNguoiDung;
        this.TenTruyen = TenTruyen;
        this.NgayDang = NgayDang;
    }

    public Truyen(int IDtl, int IDNguoiDung,  String TenTruyen, String NgayDang){
        super();
        this.IDtl = IDtl;
        this.IDNguoiDung = IDNguoiDung;
        this.TenTruyen = TenTruyen;
        this.NgayDang = NgayDang;
    }

    public int getIDT(){
        return IDT;
    }

    public void setIDT(int IDT){
        this.IDT = IDT;
    }

    public int getIDtl(){
        return IDtl;
    }

    public void setIDtl(int IDtl){
        this.IDtl = IDtl;
    }

    public int getIDNguoiDung(){
        return IDNguoiDung;
    }

    public void setIDNguoiDung(int IDNguoiDung){
        this.IDNguoiDung = IDNguoiDung;
    }

    public String getTenTruyen(){
        return TenTruyen;
    }

    public void setTenTruyen(String TenTruyen){
        this.TenTruyen = TenTruyen;
    }

    public String getNgayDang(){
        return NgayDang;
    }

    public void setNgayDang(String NgayDang){
        this.NgayDang = NgayDang;
    }
}