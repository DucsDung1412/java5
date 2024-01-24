package vn.DungVipPro.lab4.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vn.DungVipPro.lab4.dao.CartDAO;
import vn.DungVipPro.lab4.dao.ProductDAO;
import vn.DungVipPro.lab4.model.cart;
import vn.DungVipPro.lab4.model.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PageController {
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private HttpSession session;

    @GetMapping("/index")
    public String index(){
        return "/index";
    }

    @GetMapping("/menu")
    public String menu(Model model){
        Optional<product> product = productDAO.findById(Long.valueOf(1));
        model.addAttribute("product", product.get());
        return "/menu";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        List<product> cart = (List<product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.forEach(e -> {
            System.out.println(e.getName());
        });
        return "/shopping_cart";
    }

    @PostMapping("/add-to-cart")
    public String test(Model model, @RequestBody product p){
        List<product> cart = (List<product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        int b = 0;
        for(product pr : cart){
            if(pr.getId() == p.getId()){
                b++;
                break;
            }
        }
        if(b == 0){
            cart.add(p);
        }
        session.setAttribute("cart", cart);
        Optional<product> product = productDAO.findById(Long.valueOf(1));
        model.addAttribute("product", product.get());
        return "/menu";
    }

    @GetMapping("/checked")
    @Transactional
    public String menuz(){
//        product p = new product(null, "dzxc", 2323.2);
//        productDAO.save(p);
//        cart c = new cart((Long) null, "asd", 1);
//        cartDAO.save(c);
        List<product> cart = (List<product>) session.getAttribute("cart");
        if (cart != null) {
            for(product p : cart){
                cart c = new cart(null, "admin", Math.toIntExact(p.getId()));
                cartDAO.save(c);
            }
        }
        return "/index";
    }
}
