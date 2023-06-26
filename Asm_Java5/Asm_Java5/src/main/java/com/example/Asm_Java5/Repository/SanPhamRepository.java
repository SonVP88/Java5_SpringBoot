package com.example.Asm_Java5.Repository;

import com.example.Asm_Java5.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {
}
