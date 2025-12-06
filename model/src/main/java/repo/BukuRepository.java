package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import db_config.db_con;
import objek.Buku;

public class BukuRepository {
    private Buku mapToBuku(ResultSet res) throws SQLException {
        java.sql.Date sqlDate = res.getDate("tanggal_terbit");
        java.util.Date utilDate = (sqlDate != null) ? new java.util.Date(sqlDate.getTime()) : null;

        return new Buku(
                res.getString("id_buku"),
                res.getString("penulis"),
                res.getString("nama_buku"),
                res.getInt("stok"),
                utilDate
        );
    }

    // --- FITUR LISTING (USER & ADMIN) ---
    public List<Buku> getAllBuku() {
        String sql = "select id_buku,penulis,nama_buku,stok,tanggal_terbit from buku";
        List<Buku> listBuku = new ArrayList<>();
        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listBuku.add(mapToBuku(res)); // Pakai helper aman
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBuku;
    }

    public List<Buku> cariBuku(String keyword) {
        String sql = "select id_buku,penulis,nama_buku,stok,tanggal_terbit from buku where nama_buku like ? or penulis like ?";
        List<Buku> listBuku = new ArrayList<>();
        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            String key = "%" + keyword + "%";
            prep.setString(1, key);
            prep.setString(2, key);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listBuku.add(mapToBuku(res));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBuku;
    }

    public Buku getBukuById(String id) {
        String sql = "select id_buku,penulis,nama_buku,stok,tanggal_terbit from buku where id_buku = ?";
        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            ResultSet res = prep.executeQuery();
            if (res.next()) {
                return mapToBuku(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean changeStock(String id, int stok) {
        String sql = "update buku set stok = ? where id_buku = ?";
        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setInt(1, stok);
            prep.setString(2, id);
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getMaxIndexBuku() {
        String id = null;
        String sql = "select id_buku from buku order by id_buku desc limit 1";
        try (Connection conn = db_con.getConn(); Statement smt = conn.createStatement()) {
            ResultSet res = smt.executeQuery(sql);
            if (res.next()) {
                id = res.getString("id_buku");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (id == null) return 1;
        try {
            return Integer.parseInt(id.substring(id.length() - 3)) + 1;
        } catch (Exception e) { return 1; }
    }

    public boolean createBuku(String penulis, String nama_buku, int stok, String tanggalTerbit) {
        String sql = "insert into buku (id_buku,penulis,nama_buku,stok,tanggal_terbit) values (?,?,?,?,?)";
        int maxIndex = getMaxIndexBuku();
        String id = "BK" + String.format("%03d", maxIndex);
        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            LocalDate localDate = LocalDate.parse(tanggalTerbit, DateTimeFormatter.ISO_LOCAL_DATE);
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            prep.setString(1, id);
            prep.setString(2, penulis);
            prep.setString(3, nama_buku);
            prep.setInt(4, stok);
            prep.setDate(5, date);
            return prep.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateBuku(String id, String penulis, String nama_buku, int stok, String tanggalTerbit) {
        String sql = "update buku set penulis = ?, nama_buku = ?, stok = ?, tanggal_terbit = ? where id_buku = ?";
        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            LocalDate localDate = LocalDate.parse(tanggalTerbit, DateTimeFormatter.ISO_LOCAL_DATE);
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            prep.setString(1, penulis);
            prep.setString(2, nama_buku);
            prep.setInt(3, stok);
            prep.setDate(4, date);
            prep.setString(5, id);
            return prep.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBuku(String id) {
        String sql = "delete from buku where id_buku = ?";
        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            return prep.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}