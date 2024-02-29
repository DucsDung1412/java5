package vn.DungVipPro.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.demo.model.Product;
import vn.DungVipPro.demo.model.TonKho;

@Repository
public interface TonKhoDAO extends JpaRepository<TonKho, Integer> {

}
