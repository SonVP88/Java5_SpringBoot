package com.example.Asm_Java5.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChucVu {
    @Id
    @GenericGenerator(name = "generator",strategy = "giud",parameters = {})
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column (name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "chucVu")
    private List<KhachHang> khachHang;
}
