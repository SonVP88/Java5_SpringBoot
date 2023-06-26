package com.example.Asm_Java5.Client;

import com.example.Asm_Java5.Entity.GioHang;
import com.example.Asm_Java5.Entity.GioHangChiTiet;
import com.example.Asm_Java5.Entity.KhachHang;
import com.example.Asm_Java5.Entity.SanPham;
import com.example.Asm_Java5.Service.GioHangChiTietService;
import com.example.Asm_Java5.Service.GioHangService;
import com.example.Asm_Java5.Service.KhachHangService;
import com.example.Asm_Java5.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GioHangCotroller {
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    GioHangService gioHangService;

    @Autowired
    GioHangChiTietService gioHangChiTietService;


    @GetMapping("/cart/{id}")
    public String cartPage(@PathVariable(name = "id") Integer id, Model model) {
        Map<Integer, Integer> DSSP = new HashMap<>();
        List<SanPham> listTN = new ArrayList<>();
        KhachHang user = khachHangService.getById(id);
        model.addAttribute("US", user);

        GioHang g = gioHangService.getByUser(user);
        if (g == null) {
            g = new GioHang();
            g.setKhachHang(user);
            g = gioHangService.save(g);
            List<GioHangChiTiet> listGHCT = gioHangChiTietService.getByGh(g);
            for (GioHangChiTiet ghct : listGHCT) {
                listTN.add(ghct.getSanPham());
                DSSP.put(ghct.getSanPham().getIdSP(), ghct.getSoLuong());


            }
            return "/login/Client/cart";
        }
        List<GioHangChiTiet> listGHCT = gioHangChiTietService.getByGh(g);
        for (GioHangChiTiet ghct : listGHCT) {
            listTN.add(ghct.getSanPham());
            DSSP.put(ghct.getSanPham().getIdSP(), ghct.getSoLuong());

        }
        BigDecimal tongTien = gioHangService.tongTien(g);
        model.addAttribute("tongTien", tongTien);
        model.addAttribute("cart", listTN);
        model.addAttribute("DSSP", DSSP);
        return "/login/Client/cart";
    }

    @GetMapping("/cart/{id}/add-tai-nghe/{idSP}")
    public String addToCart(@PathVariable(name = "id") Integer id, @PathVariable(name = "idSP") Integer idProduct
            , Model model) {
        Map<Integer, Integer> DSSP = new HashMap<>();
        List<SanPham> listTN = new ArrayList<>();
        SanPham sp = sanPhamService.getById(idProduct);
        KhachHang user = khachHangService.getById(id);
        model.addAttribute("US", user);
        GioHang g = gioHangService.getByUser(user);
        if (g == null) {
            g = new GioHang();
            g.setKhachHang(user);
            g = gioHangService.save(g);
            List<GioHangChiTiet> listGHCT = gioHangChiTietService.getByGh(g);
            for (GioHangChiTiet ghct : listGHCT) {
                listTN.add(ghct.getSanPham());
                DSSP.put(ghct.getSanPham().getIdSP(), ghct.getSoLuong());
                ghct.setDonGia(ghct.getSanPham().getGiaban());
            }
            GioHangChiTiet gioHangChiTiet = gioHangChiTietService.getBySanPhamAndGh(sp, g);
            if (gioHangChiTiet == null) {
                gioHangChiTiet = new GioHangChiTiet();
                gioHangChiTiet.setSanPham(sp);
                gioHangChiTiet.setGh(g);
                gioHangChiTiet.setSoLuong(1);
                gioHangChiTiet.setDonGia(gioHangChiTiet.getSanPham().getGiaban());
            } else {
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
            }
            gioHangChiTiet = gioHangChiTietService.saveGHCT(gioHangChiTiet);
            return "redirect:/cart/{id}";
        }

        GioHangChiTiet gioHangChiTiet = gioHangChiTietService.getBySanPhamAndGh(sp, g);
        if (gioHangChiTiet == null) {
            gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setSanPham(sp);
            gioHangChiTiet.setGh(g);
            gioHangChiTiet.setSoLuong(1);
            gioHangChiTiet.setDonGia(gioHangChiTiet.getSanPham().getGiaban());
        } else {
            gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
        }
        List<GioHangChiTiet> listGHCT = gioHangChiTietService.getByGh(g);
        for (GioHangChiTiet ghct : listGHCT) {
            listTN.add(ghct.getSanPham());
            DSSP.put(ghct.getSanPham().getIdSP(), ghct.getSoLuong());
            ghct.setDonGia(ghct.getSanPham().getGiaban());
        }
        BigDecimal tongTien = gioHangService.tongTien(g);
        model.addAttribute("tongTien", tongTien);
        model.addAttribute("cart", listTN);
        model.addAttribute("DSSP", DSSP);
        gioHangChiTiet = gioHangChiTietService.saveGHCT(gioHangChiTiet);
        return "redirect:/cart/{id}";
    }

    @GetMapping("/cart/{id}/giamSoLuong/{idSP}")
    public String giamSoLuong(@PathVariable(name = "id") Integer id, @PathVariable("idSP") Integer idProduct
            , Model model) {
        KhachHang user = khachHangService.getById(id);
        model.addAttribute("US", user);
        GioHang gh = gioHangService.getByUser(user);
        SanPham sp = sanPhamService.getById(idProduct);
        GioHangChiTiet ghct = gioHangChiTietService.getBySanPhamAndGh(sp, gh);
        ghct.setSoLuong(ghct.getSoLuong() - 1);
        if (ghct.getSoLuong() == 0) {
            gioHangChiTietService.deleteGHCT(ghct);
            return "redirect:/cart/{id}";
        }
        ghct = gioHangChiTietService.saveGHCT(ghct);
        return "redirect:/cart/{id}";
    }

    @GetMapping("/cart/{id}/tangSoLuong/{idSP}")
    public String tangSoLuong(@PathVariable(name = "id") Integer id, @PathVariable("idSP") Integer idProduct
            , Model model) {
        KhachHang user = khachHangService.getById(id);
        model.addAttribute("US", user);
        GioHang gh = gioHangService.getByUser(user);
        SanPham sp = sanPhamService.getById(idProduct);
        GioHangChiTiet ghct = gioHangChiTietService.getBySanPhamAndGh(sp, gh);
        ghct.setSoLuong(ghct.getSoLuong() + 1);
        ghct = gioHangChiTietService.saveGHCT(ghct);
        return "redirect:/cart/{id}";
    }

    @GetMapping("/cart/{id}/xoaProduct/{idSP}")
    public String xoaTaiNghe(@PathVariable(name = "id") Integer id, @PathVariable("idSP") Integer idProduct
            , Model model) {
        KhachHang user = khachHangService.getById(id);
        model.addAttribute("US", user);
        GioHang gh = gioHangService.getByUser(user);
        SanPham sp = sanPhamService.getById(idProduct);
        GioHangChiTiet ghct = gioHangChiTietService.getBySanPhamAndGh(sp, gh);
        gioHangChiTietService.deleteGHCT(ghct);
        return "redirect:/cart/{id}";
    }

}
