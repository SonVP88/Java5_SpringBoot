package com.example.Asm_Java5.Service.impl;

import com.example.Asm_Java5.Entity.SanPham;
import com.example.Asm_Java5.Repository.SanPhamRepository;
import com.example.Asm_Java5.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceimpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham getById(Integer id) {
        return sanPhamRepository.findById(id).get();
    }

    @Override
    public void add(SanPham product) {
        sanPhamRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public Page<SanPham> findAll(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

//    @Override
//    public Iterable<SanPham> findAll(Sort sort) {
//        return sanPhamRepository.findAll();
//    }
}
