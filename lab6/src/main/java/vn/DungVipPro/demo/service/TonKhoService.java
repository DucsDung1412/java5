package vn.DungVipPro.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.DungVipPro.demo.dao.ProductDAO;
import vn.DungVipPro.demo.dao.TonKhoDAO;
import vn.DungVipPro.demo.model.Product;
import vn.DungVipPro.demo.model.TonKho;

import java.util.List;

@Service
public class TonKhoService {
    private TonKhoDAO tonKhoDAO;

    @Autowired
    public TonKhoService(TonKhoDAO tonKhoDAO) {
        this.tonKhoDAO = tonKhoDAO;
    }


    public List<TonKho> findAll(){
        return this.tonKhoDAO.findAll();
    }
}
