package vn.DungVipPro.lab4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.lab4.model.cart;
import vn.DungVipPro.lab4.model.product;

@Repository
public interface CartDAO extends JpaRepository<cart, Long> {

}
