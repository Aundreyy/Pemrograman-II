package dao;

import java.util.List;
import model.Buku;

public interface BukuDao {
    void add(Buku b) throws Exception;
    void update(Buku b) throws Exception;
    void delete(int id) throws Exception;
    List<Buku> getAll() throws Exception;
}