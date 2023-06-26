package com.example.Asm_Java5.Controller;

import com.example.Asm_Java5.Entity.KhachHang;
import com.example.Asm_Java5.Entity.SanPham;
import com.example.Asm_Java5.Service.KhachHangService;
import com.example.Asm_Java5.Service.SanPhamService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    KhachHangService khachHangService;

    private Page<SanPham> sanPhams;

    @GetMapping("/loginView")
    public String clientLogin() {
        return "login/login";
    }

    public Page<SanPham> getListTN(Model model, @RequestParam(defaultValue = "1") int page){
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 20);
        sanPhams = sanPhamService.findAll(pageable);
        model.addAttribute("page", sanPhams);
        return sanPhams;
    }

    @GetMapping("/home")
    public String home(Model model, @RequestParam(defaultValue = "1") int page) {
        sanPhams =getListTN(model,page);
        model.addAttribute("page", sanPhams);
        return "/home";
    }
    @GetMapping("/home_client/{id}")
//    public String home_client(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam("id") int id ) {
////        KhachHang khachHang = khachHangService.getById(id);
////        model.addAttribute("US", khachHang);
//        sanPhams =getListTN(model,page);
//        model.addAttribute("page", sanPhams);
//        return "/login/Client/home_client";
//    }
    public String home_client(Model model,@PathVariable(name = "id") Integer id,
                             @RequestParam(defaultValue = "1") int page) {

        KhachHang u = khachHangService.getById(id);
        model.addAttribute("US", u);
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 20);
        sanPhams = sanPhamService.findAll(pageable);
        model.addAttribute("page", sanPhams);
        return "/login/Client/home_client";
    }
    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request
            ,@RequestParam(defaultValue = "1") int page) {
        String email = request.getParameter("userName");
        String pass = request.getParameter("passWord");
        KhachHang khachHang = khachHangService.getByEmailAndMatkhau(email, pass);
        if (khachHang == null) {
            model.addAttribute("checkLogin", 1);
            return "/login/login";
        } else {
            if (khachHang.getChucVu().getMa().equals("2")) {
                model.addAttribute("US", khachHang);
                return "/login/Admin/home_admin";
            } else if (khachHang.getChucVu().getMa().equals("1")) {
                model.addAttribute("US", khachHang);
                sanPhams =getListTN(model,page);
                model.addAttribute("page", sanPhams);
                return "/login/Client/home_client";
            }
        }
        return "/login/login";
    }

}
