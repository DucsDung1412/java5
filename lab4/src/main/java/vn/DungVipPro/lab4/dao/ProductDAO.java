package vn.DungVipPro.lab4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.lab4.model.product;

@Repository
public interface ProductDAO extends JpaRepository<product, Long> {

}
