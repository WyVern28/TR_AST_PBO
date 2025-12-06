package logic;

import java.util.List;
import javax.swing.JOptionPane;
import objek.Buku;
import DTO.PinjamDTO;
import repo.BukuRepository;
import repo.PinjamRepository;

public class FiturUser {

    private BukuRepository bukuRepo = new BukuRepository();
    private PinjamRepository pinjamRepo = new PinjamRepository();

    public List<Buku> getListBuku(String keyword) {
        if (keyword == null || keyword.trim().isEmpty() || keyword.equals("Cari Buku atau Penulis")) {
            return bukuRepo.getAllBuku();
        } else {
            return bukuRepo.cariBuku(keyword);
        }
    }

    public void prosesPinjam(String idAnggota, Buku buku) {
        if (buku == null) return;

        // Cek stok terbaru
        Buku bukuTerbaru = bukuRepo.getBukuById(buku.getId_buku());

        if (bukuTerbaru != null) {
            if (bukuTerbaru.getStok() > 0) {
                boolean success = pinjamRepo.insertPinjam(idAnggota, bukuTerbaru.getId_buku(), 1);

                if (success) {
                    bukuRepo.changeStock(bukuTerbaru.getId_buku(), bukuTerbaru.getStok() - 1);
                    JOptionPane.showMessageDialog(null, "Berhasil meminjam buku: " + bukuTerbaru.getNama_buku());
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal memproses peminjaman. Cek database!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Stok buku habis!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Buku tidak ditemukan di database!");
        }
    }

    public List<PinjamDTO> getPeminjamanSaya(String idAnggota) {
        return pinjamRepo.getPinjamByAnggota(idAnggota);
    }

    public String getJumlahBukuDipinjam(String idAnggota) {
        List<PinjamDTO> list = pinjamRepo.getPinjamByAnggota(idAnggota);
        return (list != null) ? String.valueOf(list.size()) : "0";
    }

    public void prosesKembalikan(int idPinjam, String idBuku) {
        int confirm = JOptionPane.showConfirmDialog(null, "Kembalikan buku ini?");
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = pinjamRepo.returnBuku(idPinjam);

            if (success) {
                Buku buku = bukuRepo.getBukuById(idBuku);
                if (buku != null) {
                    bukuRepo.changeStock(idBuku, buku.getStok() + 1);
                }
                JOptionPane.showMessageDialog(null, "Buku berhasil dikembalikan.");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal mengembalikan buku.");
            }
        }
    }
}