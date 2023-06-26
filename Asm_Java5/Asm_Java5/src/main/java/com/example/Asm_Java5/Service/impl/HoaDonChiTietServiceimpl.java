package com.example.Asm_Java5.Service.impl;

import com.example.Asm_Java5.Entity.HoaDon;
import com.example.Asm_Java5.Entity.HoaDonChiTiet;
import com.example.Asm_Java5.Entity.SanPham;
import com.example.Asm_Java5.Repository.HoaDonChiTietRepository;
import com.example.Asm_Java5.Service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonChiTietServiceimpl implements HoaDonChiTietService {

    @Autowired
    HoaDonChiTietRepository repisitory;

    @Override
    public HoaDonChiTiet getBySanPhamAndHd(SanPham sanPham, HoaDon hd) {
        return repisitory.getBySanPhamAndAndHd(sanPham,hd);
    }

    @Override
    public List<HoaDonChiTiet> getByHd(HoaDon hd) {
        return repisitory.getByHd(hd);
    }

    @Override
    public HoaDonChiTiet saveHDCT(HoaDonChiTiet hdct) {
        return repisitory.save(hdct);
    }

    @Override
    public void deleteHDCT(HoaDonChiTiet hdct) {
        repisitory.delete(hdct);
    }
}
