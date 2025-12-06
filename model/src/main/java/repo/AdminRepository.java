package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db_config.db_con;
import objek.Admin;

public class AdminRepository {
    public Admin getAdminById(String id){
        String sql = "select id_admin,nama from admin where id_admin = ?";
        Admin admin = null;
        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            ResultSet res = prep.executeQuery();
            if(res.next()){
                admin = new Admin(res.getString("id_admin"), res.getString("nama"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return admin;
    }

    public int getMaxIndex(){
        String id = null;
        String sql = "select id_anggota from admin order by id_anggota desc limit 1";
        try(Connection conn = db_con.getConn();Statement smt = conn.createStatement()) {
            ResultSet res = smt.executeQuery(sql);
            if(res.next()){
                id = res.getString("id_admin");
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        if(id == null) return 1;
        return Integer.parseInt(id.substring(id.length()-3)) + 1;
    }
}
