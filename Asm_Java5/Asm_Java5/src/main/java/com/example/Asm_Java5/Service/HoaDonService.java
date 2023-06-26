package com.example.Asm_Java5.Service;

import com.example.Asm_Java5.Entity.HoaDon;
import com.example.Asm_Java5.Entity.KhachHang;

import java.math.BigDecimal;
import java.util.List;

public interface HoaDonService {
    HoaDon addHD(HoaDon hd);

    HoaDon getByKhachHang(KhachHang khachHang);

    BigDecimal tongTien(HoaDon hd);

    HoaDon updateHd(HoaDon hd);

    List<HoaDon> getAllBykhachHang(KhachHang khachHang);
}
