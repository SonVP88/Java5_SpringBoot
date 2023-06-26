package com.example.Asm_Java5.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "HoaDon")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class HoaDon {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "Ma")
//    private String ma;
//
//    @Column(name = "TinhTrang")
//    private Integer tinhtrang;
//
//    @Column(name = "TenNguoiNhan")
//    private String tennguoinhan;
//
//    @Column(name = "DiaChi")
//    private String diachi;
//
//    @Column(name = "Sdt")
//    private String sdt;
//
//    @ManyToOne
//    @JoinColumn(name = "IDKH")
//    private KhachHang khachHang;
//
//    @ManyToOne
//    @JoinColumn(name = "IDNV")
//    private NhanVien nhanVien;
//
//    @OneToMany(mappedBy = "hoaDon")
//    private List<HoaDonChiTiet> hoaDonChiTiets;
//}
@Entity
@Table(name = "hoadon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ngaytao")
    private Date ngayTao;

    @Column(name = "tinhtrang")
    private String tinhTrang;

    @Column(name = "tennguoinhan")
    private String nguoiNhan;

    @Column(name = "diachi")
    private String diaChi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    private KhachHang khachHang;


    @OneToMany(mappedBy = "hd")
    private List<HoaDonChiTiet> listHDCT;

}
