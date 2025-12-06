package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import DTO.PinjamDTO;
import db_config.db_con;

public class PinjamRepository {

    public boolean insertPinjam(String idAnggota, String idBuku, int jumlah) {
        String sql = "insert into pinjam (id_anggota, id_buku, jumlah, tanggal_pinjam, deadline, status) values (?, ?, ?, ?, ?, ?)";
        LocalDate today = LocalDate.now();
        LocalDate deadline = today.plusDays(7);

        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idAnggota);
            prep.setString(2, idBuku);
            prep.setInt(3, jumlah);
            prep.setDate(4, Date.valueOf(today));
            prep.setDate(5, Date.valueOf(deadline));
            prep.setString(6, "DIPINJAM");

            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PinjamDTO> getPinjamByAnggota(String idAnggota) {
        String sql = """
                select pinjam.id_pinjam, pinjam.id_anggota, pinjam.id_buku, anggota.nama, buku.nama_buku, 
                pinjam.jumlah, pinjam.tanggal_pinjam, pinjam.deadline, pinjam.tanggal_kembali, pinjam.status
                from pinjam
                inner join anggota on pinjam.id_anggota = anggota.id_anggota
                inner join buku on pinjam.id_buku = buku.id_buku
                where pinjam.id_anggota = ? AND pinjam.status = 'DIPINJAM'
                order by pinjam.deadline asc
                """;
        List<PinjamDTO> listPinjam = new ArrayList<>();

        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idAnggota);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listPinjam.add(new PinjamDTO(
                        res.getInt("id_pinjam"),
                        res.getString("id_anggota"),
                        res.getString("id_buku"),
                        res.getString("nama"),
                        res.getString("nama_buku"),
                        res.getInt("jumlah"),
                        res.getString("tanggal_pinjam"),
                        res.getString("deadline"),
                        res.getString("tanggal_kembali"),
                        res.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPinjam;
    }

    public boolean returnBuku(int idPinjam) {
        String sql = "update pinjam set status = 'DIKEMBALIKAN', tanggal_kembali = ? where id_pinjam = ?";
        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setDate(1, Date.valueOf(LocalDate.now()));
            prep.setInt(2, idPinjam);
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<PinjamDTO> getAllPinjam() {
        String sql = """
                select pinjam.id_pinjam, pinjam.id_anggota, pinjam.id_buku, anggota.nama, buku.nama_buku, 
                pinjam.jumlah, pinjam.tanggal_pinjam, pinjam.deadline, pinjam.tanggal_kembali, pinjam.status
                from pinjam
                inner join anggota on pinjam.id_anggota = anggota.id_anggota
                inner join buku on pinjam.id_buku = buku.id_buku
                """;
        List<PinjamDTO> listPinjam = new ArrayList<>();
        try (Connection conn = db_con.getConn(); PreparedStatement prep = conn.prepareStatement(sql)) {
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listPinjam.add(new PinjamDTO(
                        res.getInt("id_pinjam"), res.getString("id_anggota"), res.getString("id_buku"),
                        res.getString("nama"), res.getString("nama_buku"), res.getInt("jumlah"),
                        res.getString("tanggal_pinjam"), res.getString("deadline"),
                        res.getString("tanggal_kembali"), res.getString("status")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return listPinjam;
    }
}