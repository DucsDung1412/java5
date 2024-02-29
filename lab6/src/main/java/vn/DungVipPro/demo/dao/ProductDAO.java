package vn.DungVipPro.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.demo.model.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
    public Page<Product> findByPriceBetween(double minPrice, double maxPrice, Pageable pageable);

    public Page<Product> findByNameContains(String name, Pageable pageable);
}
