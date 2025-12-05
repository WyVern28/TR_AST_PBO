package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db_config.db_con;

public class UsersRepository {
    public String getUserRoleById(String id, String password){
        if(id == null || password == null || id.isEmpty()) return null;
        String sql = "select role from users where id_user = ? and password = ?";
        String role = null;
        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            prep.setString(2, password);
            ResultSet res = prep.executeQuery();
            if(res.next()){
                role = res.getString("role");
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return role;
    }

    public boolean createUser(String password,String role){
        AnggotaRepository anggotaRepo = new AnggotaRepository();
        AdminRepository adminRepo = new AdminRepository();
        String id = null;
        String sql = "insert into users (id_user,password,role) values (?,?,?)";
        int rowUpdate = 0;

        if(role.toLowerCase().equals("anggota")){
            int maxIndex = anggotaRepo.getMaxIndex();
            id = "AGT" + String.format("%03d", maxIndex);
        }else if (role.toLowerCase().equals("admin")){
            int maxIndex = adminRepo.getMaxIndex();
            id = "ADM" + String.format("%03", maxIndex);
        }else{
            throw new RuntimeException("Role tidak sesuai");
        }

        try(Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            prep.setString(2, password);
            prep.setString(3, role.toLowerCase());
            rowUpdate = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rowUpdate == 1;
    }
}
