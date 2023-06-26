package com.example.Asm_Java5.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

//@Entity
//@Table(name = "HoaDonChiTiet")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class HoaDonChiTiet {
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
//    @ManyToOne
//    @JoinColumn(name = "IDHoaDon")
//    private HoaDon hoaDon;
//
//    @ManyToOne
//    @JoinColumn(name = "IDProduct")
//    private SanPham product;
//}
@Entity
@Table(name = "hoadonchitiet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhoadon")
    private HoaDon hd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Idproduct")
    private SanPham sanPham;

    @Column(name = "soluong")
    private Integer soLuong;

    @Column(name = "dongia")
    private BigDecimal donGia;

}
