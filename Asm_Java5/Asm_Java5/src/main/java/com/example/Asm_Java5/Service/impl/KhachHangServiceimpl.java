package com.example.Asm_Java5.Service.impl;

import com.example.Asm_Java5.Entity.KhachHang;
import com.example.Asm_Java5.Entity.SanPham;
import com.example.Asm_Java5.Repository.KhachHangRepository;
import com.example.Asm_Java5.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceimpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public KhachHang getById(Integer id) {
        return khachHangRepository.findById(id).get();
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepository.saveAndFlush(khachHang);
    }

    @Override
    public void delete(Integer id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang getByEmailAndMatkhau(String email, String matkhau) {
        return khachHangRepository.getByEmailAndMatkhau(email, matkhau);
    }
}
