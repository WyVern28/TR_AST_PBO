package DTO;

public class PinjamDTO {
    private String nama_anggota;
    private String nama_buku;
    private int jumlah_buku;
    private String tanggal_pinjam;
    private String tanggal_kembali;
    private String deadline;
    private String status;
    
    public PinjamDTO(String nama_anggota, String nama_buku, int jumlah_buku, String tanggal_pinjam,String tanggal_kembali, String deadline, String status) {
        this.nama_anggota = nama_anggota;
        this.nama_buku = nama_buku;
        this.jumlah_buku = jumlah_buku;
        this.tanggal_pinjam = tanggal_pinjam;
        this.tanggal_kembali = tanggal_kembali;
        this.deadline = deadline;
        this.status = status;
    }
    
    public String getNama_anggota() {
        return nama_anggota;
    }
    public String getNama_buku() {
        return nama_buku;
    }
    public int getJumlah_buku() {
        return jumlah_buku;
    }
    public String getTanggal_pinjam() {
        return tanggal_pinjam;
    }
    public String getTanggal_kembali() {
        return tanggal_kembali;
    }
    public String getDeadline() {
        return deadline;
    }
    public String getStatus() {
        return status;
    }
}
