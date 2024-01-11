package vn.DungVipPro.lab2.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MathController {
    public List<String> listProduct = new ArrayList<>();
    @GetMapping("/index")
    public String home(){
        return "/math-in-input";
    }

    @GetMapping("/math")
    public String math(@RequestParam("a") Integer a, @RequestParam("b") Integer b, Model model){
        model.addAttribute("result", a+b);
        return "/math-in-input";
    }

    @GetMapping("/okindex")
    public String okindex(){
        return "/ok-index";
    }

    @GetMapping("/ok")
    public String ok(Model model){
        model.addAttribute("ok", "OK OK");
        return "/ok-index";
    }

    @GetMapping("/ok1")
    public String ok1(Model model){
        model.addAttribute("ok", "OK1");
        return "/ok-index";
    }

    @GetMapping("/ok2")
    public String ok2(Model model){
        model.addAttribute("ok", "OK2");
        return "/ok-index";
    }

    @GetMapping("/product")
    public String productindex(){
        return "/product-index";
    }

    @GetMapping("/product/{product}")
    public String getProduct(@PathVariable String product, Model model){
        model.addAttribute("product", product);
        return "/product-index";
    }

    @GetMapping("/form-product")
    public String formproduct(Model model){
        List<String> listProduct = new ArrayList<>();
        model.addAttribute("listProduct", listProduct);
        return "/product-in-input";
    }

    @PostMapping("/save-product")
    public String procductForm(@RequestParam("a") String a, @RequestParam("b") String b, Model model){
        listProduct.add(a + ": " + b);
        model.addAttribute("listProduct", listProduct);
        return "/product-in-input";
    }

    @RequestMapping("/a")
    public String m1(Model model) {
        model.addAttribute("message", "I come from a");
        return "/result-index";
    }
    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "/result-index";
    }
    @RequestMapping("/c")
    public String m3(Model model) {
        model.addAttribute("message", "I come from c");
        return "/result-index";
    }

    @RequestMapping("/d")
    public String m4(Model model) {
        model.addAttribute("message", "I come from d");
        return "/result-index";
    }

}
