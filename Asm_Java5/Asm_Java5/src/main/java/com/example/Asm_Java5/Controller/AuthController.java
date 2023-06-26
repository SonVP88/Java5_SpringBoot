package com.example.Asm_Java5.Controller;

import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
//    @Autowired
//    private KhachHangRepository khachHangRepository;
//
//    @GetMapping("/login")
//    public String showLoginForm(Model model) {
//        model.addAttribute("khachhang", new KhachHang());
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String checkLogin(Model model,
//                             @ModelAttribute("khachhang") KhachHang khachHang,
//                             BindingResult result,
//                             HttpSession session
//    ) {
//        //1 validate
//        if(result.hasErrors()) {
//            return "login";
//        }
//
//        //2 login success
//        KhachHang khachHang1= khachHangRepository.findAllByTenAndMatkhau(khachHang.getTenkh(), khachHang.getMatkhau());
//        if(khachHang1 != null) {
//            session.setAttribute("userLogged", khachHang1);
//            return "redirect:/hien-thi";
//        }
//
//        //3 login failed
//        model.addAttribute("message", "Username or password incorrect");
//        return "login";
//    }
}
