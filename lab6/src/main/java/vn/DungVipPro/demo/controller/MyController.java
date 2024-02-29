package vn.DungVipPro.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.DungVipPro.demo.model.Product;
import vn.DungVipPro.demo.model.TonKho;
import vn.DungVipPro.demo.service.ProductService;
import vn.DungVipPro.demo.service.TonKhoService;

import java.util.List;

@Controller
public class MyController {
    private ProductService productService;
    private TonKhoService tonKhoService;

    @Autowired
    public MyController(ProductService productService, TonKhoService tonKhoService) {
        this.productService = productService;
        this.tonKhoService = tonKhoService;
    }

    @GetMapping("/product/search-price")
    public String test(Model model){
        List<Product> listProduct = this.productService.findAll();
        model.addAttribute("listProduct", listProduct);
        return "/dashboard-price";
    }

    @GetMapping("/search-price")
    public String findPriceBetween(Model model, @RequestParam("min") double minPrice, @RequestParam("max") double maxPrice, Pageable pageable){
        Page<Product> listProduct = this.productService.findByPriceBetween(minPrice, maxPrice, pageable);
        model.addAttribute("listProduct", listProduct);
        return "/dashboard-price";
    }

    @GetMapping("/product/search-name")
    public String indexName(Model model){
        List<Product> listProduct = this.productService.findAll();
        model.addAttribute("listProduct", listProduct);
        return "/dashboard-name";
    }

    @GetMapping("/search-name")
    public String findByNameLike(Model model, @RequestParam("name") String name, Pageable pageable){
        Page<Product> listProduct = this.productService.findByNameLike(name, pageable);
        model.addAttribute("listProduct", listProduct);
        return "/dashboard-name";
    }

    @GetMapping("/product/search-now")
    public String indexNow(Model model){
        List<TonKho> listProduct = this.tonKhoService.findAll();
        model.addAttribute("listProduct", listProduct);
        return "/dashboard-now";
    }
}
