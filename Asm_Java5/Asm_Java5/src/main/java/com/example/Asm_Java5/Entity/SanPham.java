package com.example.Asm_Java5.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idSP;

    @Column(name = "ten")
    private String ten;

    @Column(name = "soluongton")
    private Integer soluongton;

    @Column(name = "anh")
    private String image;

    @Column(name = "gianhap")
    private BigDecimal gianhap;

    @Column(name = "giaban")
    private BigDecimal giaban;

    @Column(name = "mota")
    private String mota;



    @OneToMany(mappedBy = "sanPham")
    private List<HoaDonChiTiet> hoaDonChiTiets;

    @OneToMany(mappedBy = "sanPham")
    private  List<GioHangChiTiet> gioHangChiTiets;
}
