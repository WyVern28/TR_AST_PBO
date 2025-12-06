package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.PinjamDTO;
import db_config.db_con;

public class PinjamRepository {
    public List<PinjamDTO> getAllPinjam(){
        String sql = """
                select pinjam.id_anggota,anggota.nama,buku.nama_buku,pinjam.jumlah,pinjam.tanggal_pinjam,pinjam.deadline,pinjam.tanggal_kembali,pinjam.status
                from pinjam
                inner join anggota on pinjam.id_anggota = anggota.id_anggota
                inner join buku on pinjam.id_buku = buku.id_buku
                """;
        List<PinjamDTO> listPinjam = new ArrayList<>();

        try (Connection conn = db_con.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listPinjam.add(new PinjamDTO(res.getString("id_anggota"),
                res.getString("nama"),
                res.getString("nama_buku"),
                res.getInt("jumlah"),
                res.getString("tanggal_pinjam"),
                res.getString("deadline"),
                res.getString("tanggal_kembali"),
                res.getString("status"))
                );
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listPinjam;
    }
}
