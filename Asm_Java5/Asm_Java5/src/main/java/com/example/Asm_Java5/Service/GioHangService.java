package com.example.Asm_Java5.Service;

import com.example.Asm_Java5.Entity.GioHang;
import com.example.Asm_Java5.Entity.KhachHang;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface GioHangService {

    GioHang save(GioHang gh);

    GioHang getByUser(KhachHang khachHang);

    BigDecimal tongTien(GioHang gh);;

    void delete(GioHang gh);
}
