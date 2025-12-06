package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db_config.db_con;
import objek.Anggota;

public class AnggotaRepository {
    public Anggota getAnggotaById(String id){
        String sql = "select id_anggota,nama,status from anggota where id_anggota = ? and status = 1";
        Anggota anggota = null;
        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            ResultSet res = prep.executeQuery();
            if(res.next()){
                anggota = new Anggota(res.getString("id_anggota"),
                res.getString("nama"),
                res.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return anggota;
    }

    public int getMaxIndex(){
        String id = null;
        String sql = "select id_anggota from anggota order by id_anggota desc limit 1";
        try(Connection conn = db_con.getConn();Statement smt = conn.createStatement()) {
            ResultSet res = smt.executeQuery(sql);
            if(res.next()){
                id = res.getString("id_anggota");
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        if(id == null) return 1;
        return Integer.parseInt(id.substring(id.length()-3)) + 1;
    }

    public boolean createAnggota(String nama){
        String sql = "insert into anggota (id_anggota,nama,status) values (?,?,?)";
        int rowUpdate = 0;
        int maxIndex = getMaxIndex();
        String id = "AGT" + String.format("%03d", maxIndex);
        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            prep.setString(2, nama);
            prep.setBoolean(3, true);
            rowUpdate = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rowUpdate == 1;
    }


    public List<Anggota> getAllAnggota(){
        String sql = "select id_anggota,nama,status from anggota where status = 1";
        List<Anggota> listAnggota = new ArrayList<>();

        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listAnggota.add(new Anggota(res.getString("id_anggota"),
                res.getString("nama"),
                res.getBoolean("status"))
                );
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listAnggota;
    }

    public boolean changePassword(String id,String password){
        int rowUpdate = 0;
        String sql = "update users set password = ? where id_user = ?";
        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, password);
            prep.setString(2, id);
            rowUpdate = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rowUpdate == 1;
    }

    public boolean deleteAnggota(String id){
        String sql = "update anggota set status = false where id_anggota = ?";
        int rowUpdate = 0;
        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            rowUpdate = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rowUpdate == 1;
    }
}
