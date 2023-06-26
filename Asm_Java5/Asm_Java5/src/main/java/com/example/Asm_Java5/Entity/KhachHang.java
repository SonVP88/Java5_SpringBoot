package com.example.Asm_Java5.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "[user]")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gioitinh")
    private String gioiTinh;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "matkhau")
    private String matkhau;

    @Column(name = "email")
    private String email;

    @Column(name = "trangthai")
    private Integer trangThai;

    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> listHD;

    @OneToMany(mappedBy = "khachHang")
    private List<GioHang> listGH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idrole", referencedColumnName = "id")
    private ChucVu chucVu;
}
