package com.example.Asm_Java5.Service.impl;

import com.example.Asm_Java5.Entity.GioHang;
import com.example.Asm_Java5.Entity.GioHangChiTiet;
import com.example.Asm_Java5.Entity.SanPham;
import com.example.Asm_Java5.Repository.GioHangChiTietRepository;
import com.example.Asm_Java5.Service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GioHangChiTietServiceimpl implements GioHangChiTietService {

    @Autowired
    GioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public List<GioHangChiTiet> getByGh(GioHang gh) {
        return gioHangChiTietRepository.getByGh(gh);
    }

    @Override
    public GioHangChiTiet getBySanPhamAndGh(SanPham sanPham, GioHang gh) {
        return gioHangChiTietRepository.getBySanPhamAndGh(sanPham, gh);
    }

    @Override
    public GioHangChiTiet saveGHCT(GioHangChiTiet ghct) {
        return gioHangChiTietRepository.save(ghct);
    }

    @Override
    public void deleteGHCT(GioHangChiTiet ghct) {
        gioHangChiTietRepository.delete(ghct);
    }

    @Override
    public void deleteGioHangChiTietByIdGioHang(Integer id) {
        gioHangChiTietRepository.deleteById(id);
    }


}
