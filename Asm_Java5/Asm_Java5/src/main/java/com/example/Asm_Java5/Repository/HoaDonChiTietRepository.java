package com.example.Asm_Java5.Repository;

import com.example.Asm_Java5.Entity.HoaDon;
import com.example.Asm_Java5.Entity.HoaDonChiTiet;
import com.example.Asm_Java5.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HoaDonChiTietRepository  extends JpaRepository<HoaDonChiTiet,Integer> {
    HoaDonChiTiet getBySanPhamAndAndHd(SanPham sanPham, HoaDon hd);

    List<HoaDonChiTiet> getByHd(HoaDon hd);
}
