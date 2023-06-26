package com.example.Asm_Java5.Repository;

import com.example.Asm_Java5.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {
//    KhachHang findAllByTenkhAndMatkhau(String ten, String matkhau);
KhachHang getByEmailAndMatkhau(String email, String matkhau);
    Optional<KhachHang> findByTen(String Ten);


}
