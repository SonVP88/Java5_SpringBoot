package com.example.Asm_Java5.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

//@Entity
//@Table(name = "GioHangChiTiet")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class GioHangChiTiet {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "SoLuong")
//    private Integer soluong;
//
//    @Column(name = "DonGia")
//    private BigDecimal dongia;
//
//    @Column(name = "DonGiaKhiGiam")
//    private BigDecimal dongiakhigiam;
//
//    @ManyToOne
//    @JoinColumn(name = "IDGioHang")
//    private GioHang gioHang;
//
//    @ManyToOne
//    @JoinColumn(name = "IDProduct")
//    private SanPham product;
//
//}
@Entity
@Table(name = "giohangchitiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GioHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgiohang")
    private GioHang gh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Idproduct")
    private SanPham sanPham;

    @Column(name = "soluong")
    private Integer soLuong;

    @Column(name = "Dongia")
    private BigDecimal donGia;

}
