package com.example.Asm_Java5.Service;

import com.example.Asm_Java5.Entity.HoaDon;
import com.example.Asm_Java5.Entity.HoaDonChiTiet;
import com.example.Asm_Java5.Entity.SanPham;

import java.util.List;

public interface HoaDonChiTietService {
    HoaDonChiTiet getBySanPhamAndHd(SanPham sanPham, HoaDon hd);

    List<HoaDonChiTiet> getByHd(HoaDon hd);

    HoaDonChiTiet saveHDCT(HoaDonChiTiet hdct);

    void deleteHDCT(HoaDonChiTiet hdct);
}
