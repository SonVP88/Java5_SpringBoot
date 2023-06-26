package com.example.Asm_Java5.Repository;

import com.example.Asm_Java5.Entity.GioHang;
import com.example.Asm_Java5.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang,Integer> {
    GioHang getByKhachHang(KhachHang khachHang);
}
