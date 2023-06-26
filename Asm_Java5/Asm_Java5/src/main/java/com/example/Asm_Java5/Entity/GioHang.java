package com.example.Asm_Java5.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "giohang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer gioHangId;

    @Column(name = "tinhtrang")
    private String tinhTrang;

    @Column(name = "tennguoinhan")
    private String tenNguoiNhan;

    @Column(name = "diachi")
    private String diaChi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    private KhachHang khachHang;


    @OneToMany(mappedBy = "gh")
    private List<GioHangChiTiet> listGHCT;
}
