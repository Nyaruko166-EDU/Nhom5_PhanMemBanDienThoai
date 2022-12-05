package com.fpt.it17326.nhom5.domainmodel;

import com.fpt.it17326.nhom5.util.Util;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * AowVN_Nyaruko
 *
 */

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "MaSP")
    private String maSP;

    @Column(name = "TenSP")
    private String tenSP;

    @Column(name = "DonGia")
    private Float donGia;

    @Column(name = "MoTa")
    private String moTa;

<<<<<<< HEAD
    @Column(name = "UrlAnh")
    private String urlAnh;
=======
    @ManyToOne
    @JoinColumn(name = "IdAnh", referencedColumnName = "Id")
    private Anh anh;
>>>>>>> 5c568a85d6b46ebce7b9b9028cff26230569c535

    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdHang", referencedColumnName = "Id")
    private HangDienThoai hangdt;

    @ManyToOne
    @JoinColumn(name = "IdChip", referencedColumnName = "Id")
    private Chip chip;

    @ManyToOne
    @JoinColumn(name = "IdRam", referencedColumnName = "Id")
    private Ram ram;

    @ManyToOne
    @JoinColumn(name = "IdRom", referencedColumnName = "Id")
    private Rom rom;

    @ManyToOne
    @JoinColumn(name = "IdPin", referencedColumnName = "Id")
    private Pin pin;

    @Column(name = "SoLuong")
    private int soLuong;

<<<<<<< HEAD
=======
   

>>>>>>> 5c568a85d6b46ebce7b9b9028cff26230569c535
    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "Deleted")
    private boolean deleted;

    @Column(name = "UpdatedAt")
    private Date updatedAt;

<<<<<<< HEAD
    public SanPham(String maSP, String tenSP, Float donGia, int soLuong, String moTa, String urlAnh, MauSac mauSac, HangDienThoai hangdt, Chip chip, Ram ram, Rom rom, Pin pin, Date createdAt, boolean deleted, Date updatedAt) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.urlAnh = urlAnh;
=======
    public SanPham(String maSP, String tenSP, Float donGia, String moTa, Anh anh, MauSac mauSac, HangDienThoai hangdt, Chip chip, Ram ram, Rom rom, Pin pin, int soLuong, Date createdAt, boolean deleted, Date updatedAt) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.moTa = moTa;
        this.anh = anh;
>>>>>>> 5c568a85d6b46ebce7b9b9028cff26230569c535
        this.mauSac = mauSac;
        this.hangdt = hangdt;
        this.chip = chip;
        this.ram = ram;
        this.rom = rom;
        this.pin = pin;
        this.soLuong = soLuong;
        this.createdAt = createdAt;
        this.deleted = deleted;
        this.updatedAt = updatedAt;
    }
    
    public void setCommonData() {
        this.deleted = false;
        this.createdAt = Util.getCurrentDate();
    }

    

    

}
