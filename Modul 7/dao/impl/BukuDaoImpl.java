package dao.impl;

import java.sql.*;
import java.util.*;
import dao.BukuDao;
import model.Buku;
import util.DatabaseHelper;

public class BukuDaoImpl implements BukuDao {
    @Override
    public void add(Buku b) throws Exception {
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement("INSERT INTO buku (judul, penulis, harga, stok) VALUES (?,?,?,?)")) {
            ps.setString(1, b.getJudul()); ps.setString(2, b.getPenulis()); ps.setDouble(3, b.getHarga()); ps.setInt(4, b.getStok());
            ps.executeUpdate();
        }
    }
    @Override
    public void update(Buku b) throws Exception {
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement("UPDATE buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?")) {
            ps.setString(1, b.getJudul()); ps.setString(2, b.getPenulis()); ps.setDouble(3, b.getHarga()); ps.setInt(4, b.getStok()); ps.setInt(5, b.getBukuId());
            ps.executeUpdate();
        }
    }
    @Override
    public void delete(int id) throws Exception {
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement("DELETE FROM buku WHERE buku_id=?")) {
            ps.setInt(1, id); ps.executeUpdate();
        }
    }
    @Override
    public List<Buku> getAll() throws Exception {
        List<Buku> list = new ArrayList<>();
        try (Connection c = DatabaseHelper.getConnection(); ResultSet rs = c.createStatement().executeQuery("SELECT * FROM buku")) {
            while (rs.next()) list.add(new Buku(rs.getInt("buku_id"), rs.getString("judul"), rs.getString("penulis"), rs.getDouble("harga"), rs.getInt("stok")));
        }
        return list;
    }
}