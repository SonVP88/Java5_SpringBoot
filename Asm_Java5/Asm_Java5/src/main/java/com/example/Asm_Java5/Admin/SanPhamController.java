package com.example.Asm_Java5.Admin;


import com.example.Asm_Java5.Entity.SanPham;
import com.example.Asm_Java5.Repository.SanPhamRepository;
import com.example.Asm_Java5.Service.SanPhamService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Controller
@RequestMapping("/product/")
public class SanPhamController {

    private Page<SanPham> sanPhams;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    ServletContext app;


    @GetMapping("/hien-thi")
//    public String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
//        // Page => Trang => Noi dung cua 1 trang
//        // 6 phan tu list
//        // 1 : size ( 1 trang muon size = bn) : 4 => 4 phan tu 1/trang
//        // => Page 1: 4 phan tu dau tien => Page = 0
//        // => Page 2: 2 phan tu con lai => Page = 1
//        // 2:  soPage => Trang so may : pageNo
//        Pageable pageable = PageRequest.of(number, 2);
//        Page<SanPham> listProduct = sanPhamService.findAll(pageable);
//        model.addAttribute("listProduct", listProduct);
//        return "product/product-hienthi";
//    }
    public String ClientPage(Model model, HttpServletRequest request,
                             @RequestParam(defaultValue = "1") int page) {

        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 5);
        sanPhams = sanPhamService.findAll(pageable);
        model.addAttribute("page", sanPhams);
        return "product/product-hienthi";
    }


    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        SanPham sanPham = sanPhamService.getById(id);
        model.addAttribute("product", sanPham);
        model.addAttribute("imagePath", "/image/" + sanPham.getImage());
//        model.addAttribute("product", sanPhamService.getById(id));
        return "/product/product-detail";
    }
    @GetMapping("detail_product_client/{id}")
    public String detail_product_client(@PathVariable("id") Integer id, Model model) {
        SanPham sanPham = sanPhamService.getById(id);
        model.addAttribute("product", sanPham);
        model.addAttribute("imagePath", "/image/" + sanPham.getImage());
//        model.addAttribute("product", sanPhamService.getById(id));
        return "/login/Client/detail_product";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new SanPham());
        return "/product/product-add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        sanPhamService.delete(id);
        return "redirect:/product/hien-thi";
    }

    @PostMapping("/save")
    public String addProduct(@ModelAttribute("product") @Valid SanPham product, BindingResult bindingResult, @RequestParam("image") MultipartFile image, Model model) throws IOException {

        if (!image.isEmpty()) {

            String fileOrigionalName = image.getOriginalFilename();

            System.out.println(fileOrigionalName);

            //Date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyymmddhhmmss");
            LocalDateTime now = LocalDateTime.now();
            String datenow = dtf.format(now).toLowerCase();
            File file = new File(app.getRealPath("/image/" + datenow + "_" + fileOrigionalName));

            System.out.println(file.getAbsolutePath());

            image.transferTo(file);

            FileInputStream fis = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            try {
                for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                    //Writes to this byte array output stream
                    bos.write(buf, 0, readNum);
//                    System.out.println("read " + readNum + " bytes,");
                }
            } catch (IOException ex) {
                // Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] bytes = bos.toByteArray();

            String base64Encoded = Base64.getEncoder().encodeToString(bytes);

            System.out.println(file.getName());
            product.setImage(file.getName());

        }
//        Date createDate;
//        try {
//            createDate = dateFormat.parse(request.getParameter("createDate"));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        product.setCreateDate(createDate);

        sanPhamService.add(product);
        return "redirect:/product/hien-thi";
    }

    @PostMapping("/update")
//    public ModelAndView update(@RequestParam Integer id) {
//        ModelAndView modelAndView = new ModelAndView();
//        SanPham product = sanPhamService.getById(id);
//        modelAndView.addObject("product", product);
//        return modelAndView;
//    }
    public String update(@RequestParam("id") Integer id, @RequestParam("ma") String ma, @RequestParam("ten") String ten,
                         @RequestParam("soluongton") Integer soluongton, @RequestParam("anh") String anh,
                         @RequestParam("gianhap") BigDecimal gianhap, @RequestParam("giaban") BigDecimal giaban,
                         @RequestParam("mota") String mota, @RequestParam("image") MultipartFile image) throws IOException {
        if (!image.isEmpty()) {

            String fileOrigionalName = image.getOriginalFilename();

            System.out.println(fileOrigionalName);


            //Date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyymmddhhmmss");
            LocalDateTime now = LocalDateTime.now();
            String datenow = dtf.format(now).toLowerCase();
            File file = new File(app.getRealPath("/image/" + datenow + "_" + fileOrigionalName));

            System.out.println(file.getAbsolutePath());

            image.transferTo(file);

            FileInputStream fis = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            try {
                for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                    //Writes to this byte array output stream
                    bos.write(buf, 0, readNum);
//                    System.out.println("read " + readNum + " bytes,");
                }
            } catch (IOException ex) {
                // Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] bytes = bos.toByteArray();

            String base64Encoded = Base64.getEncoder().encodeToString(bytes);

            System.out.println(file.getName());
//            product.setImage(file.getName());
            SanPham sanPham = SanPham.builder()
                    .ten(ten)
                    .soluongton(soluongton)
                    .image(anh)
                    .gianhap(gianhap)
                    .giaban(giaban)
                    .mota(mota)
                    .image(file.getName())
                    .build();
            SanPham findsanpham = sanPhamService.getById(id);
            sanPham.setIdSP(findsanpham.getIdSP());
            BeanUtils.copyProperties(sanPham, findsanpham);
            sanPhamService.add(findsanpham);

        }
        return "redirect:/product/hien-thi";
    }
}

