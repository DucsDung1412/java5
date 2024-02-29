package vn.DungVipPro.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.DungVipPro.demo.dao.ProductDAO;
import vn.DungVipPro.demo.model.Product;


import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Boolean saveProduct(Product product){
        Product p = this.productDAO.save(product);
        if(p != null){
            return true;
        }
        return false;
    }

    public List<Product> findAll(){
        return this.productDAO.findAll();
    }

    public Page<Product> findByPriceBetween(double minPrice, double maxPrice, Pageable pageable){
        return this.productDAO.findByPriceBetween(minPrice, maxPrice, pageable);
    }

    public Page<Product> findByNameLike(String name, Pageable pageable){
        return this.productDAO.findByNameContains(name, pageable);
    }
}
