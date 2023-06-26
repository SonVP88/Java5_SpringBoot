package com.example.Asm_Java5.Client;

import com.example.Asm_Java5.Entity.ChucVu;
import com.example.Asm_Java5.Entity.KhachHang;
import com.example.Asm_Java5.Entity.SanPham;
import com.example.Asm_Java5.Repository.KhachHangRepository;
import com.example.Asm_Java5.Service.ChucVuService;
import com.example.Asm_Java5.Service.KhachHangService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Controller
public class KhachHangController {
    @Autowired
    ChucVuService chucVuService;

    @Autowired
    KhachHangService khachHangService;

    @GetMapping("/sign-up-view")
    public String viewSignUp() {
        return "/sign-up/sign-up";
    }

    @GetMapping("/edit-khachhang/{id}")
    public String viewEditUser(@PathVariable("id") Integer id,Model model) {
        model.addAttribute("khachHang", khachHangService.getById(id));
        return "/sign-up/edit-user";
    }

    @PostMapping("/sign-up-user")
    public String dangKiUser(Model model, HttpServletRequest request) {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String matkhau = request.getParameter("matkhau");

        ChucVu chucVu = chucVuService.getById(1);//1:User, 2:Admin

        KhachHang khachHang = KhachHang.builder()
                .ma(ma)
                .ten(ten)
                .gioiTinh(gioiTinh)
                .ngaySinh(Date.valueOf(ngaySinh))
                .sdt(sdt)
                .diaChi(diaChi)
                .email(email)
                .matkhau(matkhau)
                .trangThai(0)
                .chucVu(chucVu)
                .build();

        khachHangService.add(khachHang);
        return "redirect:/loginView";
    }

    @PostMapping("/update-user/{id}")
    public String CapNhapUser(@ModelAttribute("khachhang") KhachHang khachhang, @RequestParam("ngaySinh") Date ngaySinh) throws IOException {
        ChucVu chucVu = chucVuService.getById(1);
        khachhang.setNgaySinh(ngaySinh);
        khachhang.setChucVu(chucVu);
        khachHangService.add(khachhang);
        return "redirect:/loginView";
    }

    @GetMapping("/hien-thi")
    public String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        // Page => Trang => Noi dung cua 1 trang
        // 6 phan tu list
        // 1 : size ( 1 trang muon size = bn) : 4 => 4 phan tu 1/trang
        // => Page 1: 4 phan tu dau tien => Page = 0
        // => Page 2: 2 phan tu con lai => Page = 1
        // 2:  soPage => Trang so may : pageNo
        Pageable pageable = PageRequest.of(number, 2);
        Page<KhachHang> listKhachHang = khachHangService.findAll(pageable);
        model.addAttribute("listKhachHang", listKhachHang);
        return "khachHang/khachhang-hienthi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        khachHangService.delete(id);
        return "redirect:/hien-thi";
    }

}
