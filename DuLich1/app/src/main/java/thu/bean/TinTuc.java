package thu.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PC on 10/20/2016.
 */

public class TinTuc implements Serializable {
    @SerializedName("mand")
    private int mand;
    @SerializedName("username")
    private String username;
    @SerializedName("mota")
    private String mota;
    @SerializedName("chitiet")
    private String chitiet;
    @SerializedName("hinhanh")
    private String hinhanh;
    @SerializedName("ngaydang")
    private String ngaydang;

    @SerializedName("thich")
    private int thich;
    @SerializedName("xem")
    private int xem;
    @SerializedName("iddanhmuc")
    private int iddanhmuc;
    @SerializedName("binhluan")
    private String binhluan;

    @SerializedName("Lat")
    private String Lat;

    @SerializedName("Lang")
    private String Lang;

    public TinTuc(){

    }

    public TinTuc(int mand, String lang, String lat, String binhluan, int iddanhmuc, int xem, int thich, String ngaydang, String hinhanh, String chitiet, String mota, String username) {
        this.mand = mand;
        Lang = lang;
        Lat = lat;
        this.binhluan = binhluan;
        this.iddanhmuc = iddanhmuc;
        this.xem = xem;
        this.thich = thich;
        this.ngaydang = ngaydang;
        this.hinhanh = hinhanh;
        this.chitiet = chitiet;
        this.mota = mota;
        this.username = username;
    }

    public int getMand() {
        return mand;
    }

    public void setMand(int mand) {
        this.mand = mand;
    }

    public String getLang() {
        return Lang;
    }

    public void setLang(String lang) {
        Lang = lang;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getBinhluan() {
        return binhluan;
    }

    public void setBinhluan(String binhluan) {
        this.binhluan = binhluan;
    }

    public int getIddanhmuc() {
        return iddanhmuc;
    }

    public void setIddanhmuc(int iddanhmuc) {
        this.iddanhmuc = iddanhmuc;
    }

    public int getXem() {
        return xem;
    }

    public void setXem(int xem) {
        this.xem = xem;
    }

    public int getThich() {
        return thich;
    }

    public void setThich(int thich) {
        this.thich = thich;
    }

    public String getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(String ngaydang) {
        this.ngaydang = ngaydang;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
