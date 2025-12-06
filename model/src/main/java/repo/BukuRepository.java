package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db_config.db_con;
import objek.Buku;

public class BukuRepository {
    public List<Buku> getAllBuku(){
        String sql = "select id_buku,penulis,nama_buku,stok,tanggal_terbit from buku";
        List<Buku> listBuku = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                String dateString = res.getString("tanggal_terbit");
                Date date = dateFormat.parse(dateString);
                listBuku.add(new Buku(res.getString("id_buku"),
                res.getString("penulis"),
                res.getString("nama_buku"),
                res.getInt("stok"),
                date)
                );
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }catch(ParseException e){
            // TODO: handle exception
            e.printStackTrace();
        }
        return listBuku;
    }

    public boolean changeStock(String id,int stok){
        String sql = "update buku set stok = ? where id_buku = ?";
        int rowUpdate = 0;
        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setInt(1, stok);
            prep.setString(2, id);
            rowUpdate = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rowUpdate == 1;
    }

    public int getMaxIndexBuku(){
        String id = null;
        String sql = "select id_buku from buku order by id_buku desc limit 1";
        try(Connection conn = db_con.getConn();Statement smt = conn.createStatement()) {
            ResultSet res = smt.executeQuery(sql);
            if(res.next()){
                id = res.getString("id_buku");
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        if(id == null) return 1;
        return Integer.parseInt(id.substring(id.length()-3)) + 1;

    }
    public boolean createBuku(String penulis,String nama_buku,int stok,String tanggalTerbit){
        String sql = "insert into buku (id_buku,penulis,nama_buku,stok,tanggal_terbit) values (?,?,?,?,?)";
        int rowUpdate = 0;
        int maxIndex = getMaxIndexBuku();
        String id = "BK" + String.format("%03d", maxIndex);
        LocalDate localDate = LocalDate.parse(tanggalTerbit, DateTimeFormatter.ISO_LOCAL_DATE);
        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            prep.setString(1, id);
            prep.setString(2, penulis);
            prep.setString(3, nama_buku);
            prep.setInt(4, stok);
            prep.setDate(5, date);
            rowUpdate = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rowUpdate == 1;
    }

    public boolean updateBuku(String id,String penulis,String nama_buku,int stok,String tanggalTerbit){
        String sql = """
                update buku 
                set penulis = ?, nama_buku = ?, stok = ?, tanggal_terbit = ?
                where id_buku = ?
                """;
        int rowUpdate = 0;
        LocalDate localDate = LocalDate.parse(tanggalTerbit, DateTimeFormatter.ISO_LOCAL_DATE);
        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            prep.setString(1, penulis);
            prep.setString(2, nama_buku);
            prep.setInt(3, stok);
            prep.setDate(4, date);
            prep.setString(5, id);
            rowUpdate = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rowUpdate == 1;
    }

    public boolean deleteBuku(String id){
        String sql = "delete from buku where id_buku = ?";
        int rowUpdate = 0;
        try (Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            rowUpdate = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rowUpdate == 1;
    }
}
