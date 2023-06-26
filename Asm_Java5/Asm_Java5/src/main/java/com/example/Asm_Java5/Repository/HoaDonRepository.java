package com.example.Asm_Java5.Repository;

import com.example.Asm_Java5.Entity.HoaDon;
import com.example.Asm_Java5.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon,Integer> {
    HoaDon getByKhachHang(KhachHang khachHang);

    List<HoaDon> findAllBykhachHang(KhachHang khachHang);
}
