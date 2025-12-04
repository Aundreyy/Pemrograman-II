package service;

import java.util.List;
import dao.BukuDao;
import dao.impl.BukuDaoImpl;
import model.Buku;

public class BukuService {
    private BukuDao dao = new BukuDaoImpl();
    
    public List<Buku> getAll() throws Exception {
    		return dao.getAll();
    	}
    
    public void add(Buku b) throws Exception {
    		dao.add(b);
    	}
    
    public void update(Buku b) throws Exception {
    		dao.update(b);
    	}
    
    public void delete(int id) throws Exception {
    		dao.delete(id);
    	}
}