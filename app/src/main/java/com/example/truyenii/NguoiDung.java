package com.example.truyenii;
import java.net.IDN;
import java.text.SimpleDateFormat;
public class NguoiDung {
    int IDNguoiDung;
    String TenDangNhap;
    String Email;
    String NgayThamGia;
    int Level;
    int Status;

    public NguoiDung(int IDNguoiDung, String TenDangNhap, String Email, String NgayThamGia, int Level, int Status){
        super();
        this.IDNguoiDung = IDNguoiDung;
        this.TenDangNhap = TenDangNhap;
        this.Email = Email;
        this.NgayThamGia = NgayThamGia;
        this.Level = Level;
        this. Status = Status;
    }

    public NguoiDung(String TenDangNhap, String Email, String NgayThamGia, int Level, int Status){
        super();
        this.TenDangNhap = TenDangNhap;
        this.Email = Email;
        this.NgayThamGia = NgayThamGia;
        this.Level = Level;
        this. Status = Status;
    }

    public int getIDNguoiDung(){
        return IDNguoiDung;
    }

    public void setIDNguoiDung(int IDNguoiDung){
        this.IDNguoiDung = IDNguoiDung;
    }

    public String getTenDangNhap(){
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap){
        this.TenDangNhap = TenDangNhap;
    }

    public String getEmail(){
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public String getNgayThamGia(){
        return NgayThamGia;
    }

    public void setNgayThamGia(String NgayThamGia){
        this.NgayThamGia = NgayThamGia;
    }

    public int getLevel(){
        return Level;
    }

    public void setLevel(int Level){
        this.Level = Level;
    }

    public int getStatus(){
        return Status;
    }

    public void setStatus(int Status){
        this.Status = Status;
    }
}

