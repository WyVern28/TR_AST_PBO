package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
