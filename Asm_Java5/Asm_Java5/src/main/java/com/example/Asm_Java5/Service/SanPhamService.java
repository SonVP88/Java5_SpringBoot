package com.example.Asm_Java5.Service;

import com.example.Asm_Java5.Entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface SanPhamService {

    public List<SanPham> getAll();

    public SanPham getById(Integer id);

    public void add(SanPham product);

    public void delete(Integer id);

    Page<SanPham> findAll(Pageable pageable);

//    Iterable<SanPham> findAll(Sort sort);
}
