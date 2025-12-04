package dao.impl;

import java.sql.*;
import java.util.*;
import dao.PenjualanDao;
import model.Penjualan;
import util.DatabaseHelper;

public class PenjualanDaoImpl implements PenjualanDao {
    @Override
    public void add(Penjualan p) throws Exception {
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement("INSERT INTO penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?,?,?,?,?)")) {
            ps.setInt(1, p.jumlahProperty().get()); ps.setDouble(2, p.totalHargaProperty().get()); ps.setString(3, p.tanggalProperty().get()); ps.setInt(4, p.pelangganIdProperty().get()); ps.setInt(5, p.bukuIdProperty().get());
            ps.executeUpdate();
        }
    }
    @Override
    public void delete(int id) throws Exception {
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement("DELETE FROM penjualan WHERE penjualan_id=?")) {
            ps.setInt(1, id); ps.executeUpdate();
        }
    }
    @Override
    public List<Penjualan> getAll() throws Exception {
        List<Penjualan> list = new ArrayList<>();
        try (Connection c = DatabaseHelper.getConnection(); ResultSet rs = c.createStatement().executeQuery("SELECT * FROM penjualan")) {
            while (rs.next()) list.add(new Penjualan(rs.getInt("penjualan_id"), rs.getInt("jumlah"), rs.getDouble("total_harga"), rs.getString("tanggal"), rs.getInt("pelanggan_id"), rs.getInt("buku_id")));
        }
        return list;
    }
}