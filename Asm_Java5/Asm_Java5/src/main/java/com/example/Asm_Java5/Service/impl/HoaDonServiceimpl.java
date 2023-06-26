package com.example.Asm_Java5.Service.impl;

import com.example.Asm_Java5.Entity.HoaDon;
import com.example.Asm_Java5.Entity.HoaDonChiTiet;
import com.example.Asm_Java5.Entity.KhachHang;
import com.example.Asm_Java5.Repository.HoaDonRepository;
import com.example.Asm_Java5.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class HoaDonServiceimpl implements HoaDonService {

    @Autowired
    HoaDonRepository repository;

    @Override
    public HoaDon addHD(HoaDon hd) {
        return repository.save(hd);
    }

    @Override
    public HoaDon getByKhachHang(KhachHang khachHang) {
        return repository.getByKhachHang(khachHang);
    }

    @Override
    public BigDecimal tongTien(HoaDon hd) {
        double tongTien = 0;
        List<HoaDonChiTiet> listHDCT = hd.getListHDCT();
        for (HoaDonChiTiet hdct : listHDCT) {
            double thanhTien = hdct.getSoLuong() * Double.parseDouble(String.valueOf(hdct.getSanPham().getGiaban()));
            tongTien += thanhTien;
        }
        return BigDecimal.valueOf(tongTien);
    }

    @Override
    public HoaDon updateHd(HoaDon hd) {
        return repository.save(hd);
    }

    @Override
    public List<HoaDon> getAllBykhachHang(KhachHang khachHang) {
        return repository.findAllBykhachHang(khachHang);
    }
}
