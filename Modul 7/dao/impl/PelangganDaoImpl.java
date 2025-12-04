package dao.impl;

import java.sql.*;
import java.util.*;
import dao.PelangganDao;
import model.Pelanggan;
import util.DatabaseHelper;

public class PelangganDaoImpl implements PelangganDao {
    @Override
    public void add(Pelanggan p) throws Exception {
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement("INSERT INTO pelanggan (nama, email, telepon) VALUES (?,?,?)")) {
            ps.setString(1, p.getNama()); ps.setString(2, p.getEmail()); ps.setString(3, p.getTelepon());
            ps.executeUpdate();
        }
    }
    @Override
    public void update(Pelanggan p) throws Exception {
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement("UPDATE pelanggan SET nama=?, email=?, telepon=? WHERE pelanggan_id=?")) {
            ps.setString(1, p.getNama()); ps.setString(2, p.getEmail()); ps.setString(3, p.getTelepon()); ps.setInt(4, p.getPelangganId());
            ps.executeUpdate();
        }
    }
    @Override
    public void delete(int id) throws Exception {
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement("DELETE FROM pelanggan WHERE pelanggan_id=?")) {
            ps.setInt(1, id); ps.executeUpdate();
        }
    }
    @Override
    public List<Pelanggan> getAll() throws Exception {
        List<Pelanggan> list = new ArrayList<>();
        try (Connection c = DatabaseHelper.getConnection(); ResultSet rs = c.createStatement().executeQuery("SELECT * FROM pelanggan")) {
            while (rs.next()) list.add(new Pelanggan(rs.getInt("pelanggan_id"), rs.getString("nama"), rs.getString("email"), rs.getString("telepon")));
        }
        return list;
    }
}