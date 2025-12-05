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
}
