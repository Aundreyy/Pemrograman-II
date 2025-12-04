package dao;

import java.util.List;
import model.Penjualan;

public interface PenjualanDao {
    void add(Penjualan p) throws Exception;
    void delete(int id) throws Exception;
    List<Penjualan> getAll() throws Exception;
}