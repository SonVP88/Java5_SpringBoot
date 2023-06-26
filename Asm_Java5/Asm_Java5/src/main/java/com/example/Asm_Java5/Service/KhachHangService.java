package com.example.Asm_Java5.Service;

import com.example.Asm_Java5.Entity.KhachHang;
import com.example.Asm_Java5.Entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KhachHangService {
    public List<KhachHang> getAll();
Page<KhachHang> findAll(Pageable pageable);
    public KhachHang getById(Integer id);

    public void add(KhachHang khachHang);

    public void delete(Integer id);

    KhachHang getByEmailAndMatkhau(String email, String matkhau);
}
