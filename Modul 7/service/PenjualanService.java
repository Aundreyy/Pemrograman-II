package service;

import java.util.List;
import dao.PenjualanDao;
import dao.impl.PenjualanDaoImpl;
import model.Penjualan;

public class PenjualanService {
    private PenjualanDao dao = new PenjualanDaoImpl();
    
    public List<Penjualan> getAll() throws Exception {
    		return dao.getAll();
    	}
    
    public void add(Penjualan p) throws Exception {
    		dao.add(p);
    	}
    
    public void delete(int id) throws Exception {
    		dao.delete(id);
    	}
}