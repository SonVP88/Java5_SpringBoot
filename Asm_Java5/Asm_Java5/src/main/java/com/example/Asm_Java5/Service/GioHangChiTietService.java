package com.example.Asm_Java5.Service;

import com.example.Asm_Java5.Entity.GioHang;
import com.example.Asm_Java5.Entity.GioHangChiTiet;
import com.example.Asm_Java5.Entity.SanPham;


import java.util.List;


public interface GioHangChiTietService {
    List<GioHangChiTiet> getByGh(GioHang gh);

    GioHangChiTiet getBySanPhamAndGh(SanPham sanPham, GioHang gh);

    GioHangChiTiet saveGHCT(GioHangChiTiet ghct);

    void deleteGHCT(GioHangChiTiet ghct);
    void deleteGioHangChiTietByIdGioHang(Integer id);
}
