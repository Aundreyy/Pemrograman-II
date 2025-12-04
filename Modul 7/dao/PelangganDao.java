package dao;

import java.util.List;
import model.Pelanggan;

public interface PelangganDao {
    void add(Pelanggan p) throws Exception;
    void update(Pelanggan p) throws Exception;
    void delete(int id) throws Exception;
    List<Pelanggan> getAll() throws Exception;
}