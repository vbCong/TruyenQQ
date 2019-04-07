package com.example.truyenii;

public class TheLoai {
    int IDtl;
    String TenTL;

    public TheLoai(int IDtl, String TenTL){
        super();
        this.IDtl = IDtl;
        this.TenTL = TenTL;
    }

    public TheLoai(String TenTL){
        super();
        this.TenTL = TenTL;
    }

    public int getIDtl(){
        return IDtl;
    }

    public void setIDtl(int IDtl){
        this.IDtl = IDtl;
    }

    public String getTenTL(){
        return TenTL;
    }

    public void setTenTL(String TenTL){
        this.TenTL = TenTL;
    }

}