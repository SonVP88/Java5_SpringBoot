package com.example.Asm_Java5.Service.impl;

import com.example.Asm_Java5.Entity.GioHang;
import com.example.Asm_Java5.Entity.GioHangChiTiet;
import com.example.Asm_Java5.Entity.KhachHang;
import com.example.Asm_Java5.Entity.SanPham;
import com.example.Asm_Java5.Repository.GioHangChiTietRepository;
import com.example.Asm_Java5.Repository.GioHangRepository;
import com.example.Asm_Java5.Repository.KhachHangRepository;
import com.example.Asm_Java5.Repository.SanPhamRepository;
import com.example.Asm_Java5.Service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GioHangServiceimpl implements GioHangService {

    @Autowired
    GioHangRepository gioHangRepository;


    @Override
    public GioHang save(GioHang gh) {
        return gioHangRepository.save(gh);
    }

    @Override
    public GioHang getByUser(KhachHang khachHang) {
        return gioHangRepository.getByKhachHang(khachHang);
    }

    @Override
    public BigDecimal tongTien(GioHang gh) {
        double tongTien = 0;
        List<GioHangChiTiet> listGHCT = gh.getListGHCT();
        for(GioHangChiTiet ghct: listGHCT) {
            double thanhTien = ghct.getSoLuong() * Double.parseDouble(String.valueOf(ghct.getSanPham().getGiaban()));
            tongTien += thanhTien;
        }
        return BigDecimal.valueOf(tongTien);
    }

    @Override
    public void delete(GioHang gh) {
        gioHangRepository.delete(gh);
    }
}
