package service;

import java.util.List;
import dao.PelangganDao;
import dao.impl.PelangganDaoImpl;
import model.Pelanggan;

public class PelangganService {
    private PelangganDao dao = new PelangganDaoImpl();
    
    public List<Pelanggan> getAll() throws Exception {
    		return dao.getAll();
    	}
    public void add(Pelanggan p) throws Exception {
    		dao.add(p);
    	}
    public void update(Pelanggan p) throws Exception {
    		dao.update(p);
    	}
    public void delete(int id) throws Exception {
    		dao.delete(id);
    	}
}