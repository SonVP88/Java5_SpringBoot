package com.example.Asm_Java5.Repository;

import com.example.Asm_Java5.Entity.GioHang;
import com.example.Asm_Java5.Entity.GioHangChiTiet;
import com.example.Asm_Java5.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet,Integer> {
    GioHangChiTiet getBySanPhamAndGh(SanPham sanPham, GioHang gh);

    List<GioHangChiTiet> getByGh(GioHang gh);
}
